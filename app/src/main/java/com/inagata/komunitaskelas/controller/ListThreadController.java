package com.inagata.komunitaskelas.controller;

import android.os.Bundle;

import com.inagata.komunitaskelas.data.api.KomunitasKelasApiSample;
import com.inagata.komunitaskelas.data.model.SubjectClass;

import java.util.ArrayList;
import java.util.List;

import id.zelory.benih.controller.BenihController;
import id.zelory.benih.util.BenihScheduler;
import timber.log.Timber;

/**
 * Created on : December 12, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class ListThreadController extends BenihController<ListThreadController.Presenter> {
    private List<SubjectClass> subjectClassList;

    public ListThreadController(Presenter presenter) {
        super(presenter);
        Timber.d("ThreadControllerList created");
    }

    public void loadDataListSubject() {
        presenter.showLoading();
        KomunitasKelasApiSample.grabData()
                .getAPI()
                .getSubjectList()
                .compose(BenihScheduler.pluck().applySchedulers(BenihScheduler.Type.IO))
                .subscribe(subjectClasses -> {
                    this.subjectClassList = subjectClasses;
                    presenter.getListSubject(subjectClassList);
                }, throwable -> {
                    Timber.d(throwable.getMessage());
                    presenter.showError(throwable);
                    presenter.dismissLoading();
                });
    }

    @Override
    public void saveState(Bundle bundle) {
        bundle.putParcelableArrayList("listSubject", (ArrayList<SubjectClass>) subjectClassList);
    }

    @Override
    public void loadState(Bundle bundle) {
        subjectClassList = bundle.getParcelableArrayList("listSubject");
        if (subjectClassList != null) {
            presenter.getListSubject(subjectClassList);
        } else {
            presenter.showError(new Throwable("Error"));
        }
    }

    public interface Presenter extends BenihController.Presenter {
        void showLoading();

        void dismissLoading();

        void getListSubject(List<SubjectClass> subjectClassList);
    }
}
