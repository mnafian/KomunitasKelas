package com.inagata.komunitaskelas.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.inagata.komunitaskelas.R;

import java.lang.reflect.Field;

import id.zelory.benih.fragment.BenihFragment;
import id.zelory.benih.util.BenihBus;

/**
 * Created on : December 13, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class ParentFragment extends BenihFragment {
    @Override
    protected int getFragmentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onViewReady(Bundle bundle) {
    }

    @Override
    public void replace(int containerId, BenihFragment fragment, boolean addToBackStack) {
        if (addToBackStack) {
            try {
                getChildFragmentManager().beginTransaction()
                        .replace(containerId, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(null)
                        .commit();
            } catch (Exception e) {
                resetChildFragmentManager();
                BenihBus.pluck().send(new ReloadEvent());
            }

        } else {
            try {
                getChildFragmentManager().beginTransaction()
                        .replace(containerId, fragment, fragment.getClass().getSimpleName())
                        .commit();
            } catch (Exception e) {
                resetChildFragmentManager();
                BenihBus.pluck().send(new ReloadEvent());
            }
        }
    }

    private void resetChildFragmentManager() {
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        resetChildFragmentManager();
    }
}

