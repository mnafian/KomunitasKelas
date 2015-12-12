package com.inagata.komunitaskelas;

import android.os.Handler;

import id.zelory.benih.BenihApplication;
import in.co.madhur.chatlib.NativeLoader;
import timber.log.Timber;

/**
 * Created on : December 06, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class KomunitasKelasApp extends BenihApplication {

    private static KomunitasKelasApp komunitasKelasApp;
    public static volatile Handler applicationHandler = null;

    @Override
    public void onCreate() {
        super.onCreate();
        komunitasKelasApp = this;
        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
        applicationHandler = new Handler(drop().getMainLooper());

        NativeLoader.initNativeLibs(KomunitasKelasApp.drop());

    }

    public static KomunitasKelasApp drop(){
        return komunitasKelasApp;
    }
}
