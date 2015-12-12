package com.inagata.komunitaskelas.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.ui.activity.CreateClassActivity;

import butterknife.Bind;
import id.zelory.benih.fragment.BenihFragment;

/**
 * Created on : December 06, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class HomeFragment extends BenihFragment {

    @Bind(R.id.fab) FloatingActionButton fab;

    @Override
    protected int getFragmentView() {
        return R.layout.kom_fragment_home;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        fab.setOnClickListener(view -> addNewClass());
    }

    public void addNewClass(){
        Intent intent = new Intent(getActivity(), CreateClassActivity.class);
        startActivity(intent);
    }
}
