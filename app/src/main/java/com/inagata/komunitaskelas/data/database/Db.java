package com.inagata.komunitaskelas.data.database;

import android.database.Cursor;

import com.inagata.komunitaskelas.data.model.LoginCredential;

/**
 * Created on : December 10, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class Db
{
    public static final String COLUMN_ID_EMAIL = "email";
    public static final String COLUMN_API_KEY = "api_key";
    public static final String COLUMN_ID_SCHOOL = "id_school";

    public static abstract class UserAttribute {
        public static final String TABLE_NAME = "userattribute";

        public static final String CREATE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID_EMAIL + " INTEGER PRIMARY KEY," +
                        COLUMN_API_KEY + " TEXT NOT NULL," +
                        COLUMN_ID_SCHOOL + " TEXT NOT NULL" +
                        " )";

        public static LoginCredential parseCursor(Cursor cursor) {
            LoginCredential loginCredential = new LoginCredential();

            return loginCredential;
        }
    }
}
