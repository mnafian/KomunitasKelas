package com.inagata.komunitaskelas.controller;

import android.os.Bundle;

import com.inagata.komunitaskelas.data.api.KomunitasKelasApi;
import com.inagata.komunitaskelas.data.model.LoginCredential;

import id.zelory.benih.controller.BenihController;
import id.zelory.benih.util.BenihScheduler;
import rx.Observable;

/**
 * Created on : December 10, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class LoginController extends BenihController<LoginController.Presenter>{

    private LoginCredential loginCredential;

    public LoginController(Presenter presenter)
    {
        super(presenter);
    }

    public void setLoginCredential (LoginCredential loginCredential){
        this.loginCredential = loginCredential;
    }

    public void doLogin(String email, String password)
    {
        presenter.showLoading();
        KomunitasKelasApi.grabData()
                .getAPI()
                .doLogin(email, password)
                .compose(BenihScheduler.pluck().applySchedulers(BenihScheduler.Type.IO))
                .flatMap(loginResponse -> Observable.from(loginResponse.getResult()))
                .map(credential -> {
                    credential.setEmail();
                })
    }

    @Override
    public void saveState(Bundle bundle) {

    }

    @Override
    public void loadState(Bundle bundle) {

    }

    public interface Presenter extends BenihController.Presenter{
        void doLogin();
        void showLoading();
    }

}
