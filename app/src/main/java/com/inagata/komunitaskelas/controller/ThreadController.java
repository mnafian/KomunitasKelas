package com.inagata.komunitaskelas.controller;

import android.os.Bundle;

import com.inagata.komunitaskelas.data.api.KomunitasKelasApiSample;
import com.inagata.komunitaskelas.data.model.DetailThread;

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
public class ThreadController extends BenihController<ThreadController.Presenter> {

    private DetailThread detailThread;

    public ThreadController(Presenter presenter) {
        super(presenter);
        Timber.d("DetailThread created");
    }

    public void loadDetailThread() {
        presenter.showLoading();
        KomunitasKelasApiSample.grabData()
                .getAPI()
                .getDetailThread()
                .compose(BenihScheduler.pluck().applySchedulers(BenihScheduler.Type.IO))
                .subscribe(detailThread -> {
                    this.detailThread = detailThread;
                    presenter.getDetailThread(detailThread);
                    presenter.dismissLoading();
                }, throwable -> {
                    presenter.showError(throwable);
                    presenter.dismissLoading();
                });
    }

    @Override
    public void saveState(Bundle bundle) {
        bundle.putParcelable("detailThread", detailThread);
    }

    @Override
    public void loadState(Bundle bundle) {
        detailThread = bundle.getParcelable("detailThread");
        if (detailThread != null) {
            presenter.getDetailThread(detailThread);
        } else {
            presenter.showError(new Throwable("Error"));
        }
    }

    public interface Presenter extends BenihController.Presenter {
        void showLoading();

        void dismissLoading();

        void getDetailThread(DetailThread detailThreads);
    }
}
