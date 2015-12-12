package com.inagata.komunitaskelas.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.inagata.komunitaskelas.R;

import id.zelory.benih.BenihActivity;
import id.zelory.benih.util.BenihPreferenceUtils;

/**
 * Created on : December 06, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class SplashScreen extends BenihActivity {
    @Override
    protected int getActivityView() {
        return R.layout.kom_activity_splash;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        sendBroadcast(new Intent("com.inagata.komunitaskelas.ACTION_START"));

        if (BenihPreferenceUtils.getBoolean(this, "loaded"))
        {
            new Handler().postDelayed(() -> startActivity(new Intent(this, MainActivity.class)), 1800);
        } else
        {
            new Handler().postDelayed(() -> startActivity(new Intent(this, WelcomeScreen.class)), 1800);
        }
    }
}
