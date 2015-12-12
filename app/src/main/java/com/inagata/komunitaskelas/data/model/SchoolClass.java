package com.inagata.komunitaskelas.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created on : December 10, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class SchoolClass implements Parcelable {

    private String error;
    private String message;
    private String class_id;

    protected SchoolClass (Parcel in)
    {
        error = in.readString();
        message =  in.readString();
        class_id = in.readString();
    }

    public static final Creator<SchoolClass> CREATOR = new Creator<SchoolClass>() {
        @Override
        public SchoolClass createFromParcel(Parcel in) {
            return new SchoolClass(in);
        }

        @Override
        public SchoolClass[] newArray(int size) {
            return new SchoolClass[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(error);
        dest.writeString(message);
        dest.writeString(class_id);
    }
}
