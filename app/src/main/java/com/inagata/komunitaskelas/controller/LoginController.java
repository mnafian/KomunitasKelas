package com.inagata.komunitaskelas.controller;

import android.os.Bundle;

import com.inagata.komunitaskelas.data.api.KomunitasKelasApi;
import com.inagata.komunitaskelas.data.model.LoginCredential;

import id.zelory.benih.controller.BenihController;
import id.zelory.benih.util.BenihScheduler;
import timber.log.Timber;

/**
 * Created on : December 10, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class LoginController extends BenihController<LoginController.Presenter>{

    private LoginCredential credential;

    public LoginController(Presenter presenter)
    {
        super(presenter);
        Timber.d("LoginController created");
    }

    public void doLogin(String email, String password)
    {
        presenter.showLoading();
        KomunitasKelasApi.grabData()
                .getAPI()
                .doLogin(email, password)
                .compose(BenihScheduler.pluck().applySchedulers(BenihScheduler.Type.IO))
                .subscribe(credentialList -> {
                    this.credential = credentialList;
                    presenter.getListCredential(credential);
                    presenter.dismissLoading();
                }, throwable -> {
                    Timber.d(throwable.getMessage());
                    presenter.showError(throwable);
                    presenter.dismissLoading();
                });
    }

    @Override
    public void saveState(Bundle bundle) {
        bundle.putParcelable("credential", credential);
    }

    @Override
    public void loadState(Bundle bundle) {
        credential = bundle.getParcelable("credential");
        if (credential != null) {
            presenter.getListCredential(credential);
        } else {
            presenter.showError(new Throwable("Error"));
        }
    }

    public interface Presenter extends BenihController.Presenter{
        void showLoading();

        void dismissLoading();

        void getListCredential(LoginCredential credential);
    }

}
