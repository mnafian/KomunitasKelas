package com.inagata.komunitaskelas.controller;

import android.os.Bundle;

import com.inagata.komunitaskelas.data.model.SchoolClass;

import java.util.List;

import id.zelory.benih.controller.BenihController;

/**
 * Created on : December 12, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class ListNotificationController extends BenihController<ListNotificationController.Presenter> {

    public ListNotificationController(Presenter presenter) {
        super(presenter);
    }

    @Override
    public void saveState(Bundle bundle) {

    }

    @Override
    public void loadState(Bundle bundle) {

    }

    public interface Presenter extends BenihController.Presenter {
        void showLoading();

        void dismissLoading();

        void getListClass(List<SchoolClass> schoolClassList);
    }
}
