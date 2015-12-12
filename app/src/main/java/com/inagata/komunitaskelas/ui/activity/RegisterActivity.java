package com.inagata.komunitaskelas.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.inagata.komunitaskelas.R;

import butterknife.Bind;
import id.zelory.benih.BenihActivity;

/**
 * Created on : December 07, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class RegisterActivity extends BenihActivity
{

    @Bind(R.id.input_username) EditText inputUsername;
    @Bind(R.id.input_nama_lengkap) EditText inputNamaLengkap;
    @Bind(R.id.input_tipeuser) EditText inputTipeUser;
    @Bind(R.id.input_provinsi) EditText inputProvinsi;
    @Bind(R.id.input_kota) EditText inputKota;
    @Bind(R.id.input_sekolah) EditText inputSekolah;
    @Bind(R.id.input_password) EditText inputPassword;
    @Bind(R.id.input_confirm_pass) EditText inputConfirmPass;

    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected int getActivityView()
    {
        return R.layout.kom_activity_register;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState)
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.activity_register);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_finish, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
