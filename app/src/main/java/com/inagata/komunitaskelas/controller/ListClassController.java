package com.inagata.komunitaskelas.controller;

import android.os.Bundle;

import com.inagata.komunitaskelas.data.api.KomunitasKelasApiSample;
import com.inagata.komunitaskelas.data.model.SchoolClass;

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
public class ListClassController extends BenihController<ListClassController.Presenter> {

    private List<SchoolClass> schoolClassList;

    public ListClassController(Presenter presenter) {
        super(presenter);
        Timber.d("ClassControllerList created");
    }

    public void loadDataListClass() {
        presenter.showLoading();
        KomunitasKelasApiSample
                .grabData()
                .getAPI()
                .getClassList()
                .compose(BenihScheduler.pluck().applySchedulers(BenihScheduler.Type.IO))
                .subscribe(classList -> {
                    this.schoolClassList = classList;
                    presenter.getListClass(schoolClassList);
                    presenter.dismissLoading();
                }, throwable -> {
                    Timber.d(throwable.getMessage());
                    presenter.showError(throwable);
                    presenter.dismissLoading();
                });
    }

    @Override
    public void saveState(Bundle bundle) {
        bundle.putParcelableArrayList("listclass", (ArrayList<SchoolClass>) schoolClassList);
    }

    @Override
    public void loadState(Bundle bundle) {
        schoolClassList = bundle.getParcelableArrayList("listClass");
        if (schoolClassList != null) {
            presenter.getListClass(schoolClassList);
        } else {
            presenter.showError(new Throwable("Error"));
        }
    }

    public interface Presenter extends BenihController.Presenter {
        void showLoading();

        void dismissLoading();

        void getListClass(List<SchoolClass> schoolClassList);
    }
}
