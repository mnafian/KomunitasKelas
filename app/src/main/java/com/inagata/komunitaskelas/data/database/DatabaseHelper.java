package com.inagata.komunitaskelas.data.database;

import android.database.Cursor;

import com.inagata.komunitaskelas.BuildConfig;
import com.inagata.komunitaskelas.KomunitasKelasApp;
import com.inagata.komunitaskelas.data.model.LoginCredential;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.ArrayList;
import java.util.List;

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

    public static DatabaseHelper drop() {
        return DBTULUNG;
    }

    public Observable<List<LoginCredential>> getUserAttribute() {
        return briteDatabase.createQuery(Db.UserAttribute.TABLE_NAME, "SELECT * FROM " + Db.UserAttribute.TABLE_NAME)
                .compose(BenihScheduler.pluck().applySchedulers(BenihScheduler.Type.IO))
                .map(query -> {
                    Cursor cursor = query.run();
                    List<LoginCredential> credentials = new ArrayList<>();
                    while (cursor.moveToNext()) {
                        credentials.add(Db.UserAttribute.parseCursor(cursor));
                    }
                    return credentials;
                });
    }
}
