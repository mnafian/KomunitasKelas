package com.inagata.komunitaskelas.data.database;

import com.inagata.komunitaskelas.BuildConfig;
import com.inagata.komunitaskelas.KomunitasKelasApp;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

/**
 * Created on : December 10, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public enum DatabaseHelper {
    DBTULUNG;
    private final BriteDatabase briteDatabase;


    DatabaseHelper()
    {
        DbOpenHelper dbOpenHelper = new DbOpenHelper(KomunitasKelasApp.drop().getBaseContext());
        SqlBrite sqlBrite = SqlBrite.create();
        briteDatabase = sqlBrite.wrapDatabaseHelper(dbOpenHelper);
        briteDatabase.setLoggingEnabled(BuildConfig.DEBUG);
    }
}
