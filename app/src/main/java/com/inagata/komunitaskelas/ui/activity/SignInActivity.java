package com.inagata.komunitaskelas.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
public class SignInActivity extends BenihActivity
{
    @Bind(R.id.button_signin) Button signInButton;
    @Bind(R.id.link_register) TextView signUpButton;

    @Override
    protected int getActivityView() {
        return R.layout.kom_activity_sign_in;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        signInButton.setOnClickListener(view -> doLogin());
        signUpButton.setOnClickListener(view -> doRegister());
    }

    public void doLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void doRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
