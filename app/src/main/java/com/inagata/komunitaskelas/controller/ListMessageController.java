package com.inagata.komunitaskelas.controller;

import android.os.Bundle;

import com.inagata.komunitaskelas.data.api.KomunitasKelasApiSample;
import com.inagata.komunitaskelas.data.model.PrivateMessage;

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
public class ListMessageController extends BenihController<ListMessageController.Presenter> {

    private List<PrivateMessage> privateMessageList;

    public ListMessageController(Presenter presenter) {
        super(presenter);
        Timber.d("ListControllerList created");
    }

    public void getListMessage() {
        presenter.showLoading();
        KomunitasKelasApiSample.grabData()
                .getAPI()
                .getMessageList()
                .compose(BenihScheduler.pluck().applySchedulers(BenihScheduler.Type.IO))
                .subscribe(privateMessages -> {
                    this.privateMessageList = privateMessages;
                    presenter.getListMessages(privateMessageList);
                    presenter.dismissLoading();
                }, throwable -> {
                    Timber.d(throwable.getMessage());
                    presenter.showError(throwable);
                    presenter.dismissLoading();
                });
    }

    @Override
    public void saveState(Bundle bundle) {
        bundle.putParcelableArrayList("listMessage", (ArrayList<PrivateMessage>) privateMessageList);
    }

    @Override
    public void loadState(Bundle bundle) {
        privateMessageList = bundle.getParcelableArrayList("listMessage");
        if (privateMessageList != null) {
            presenter.getListMessages(privateMessageList);
        } else {
            presenter.showError(new Throwable("Error"));
        }
    }

    public interface Presenter extends BenihController.Presenter {
        void showLoading();

        void dismissLoading();

        void getListMessages(List<PrivateMessage> privateMessageList);
    }
}
