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
public class SubjectClass implements Parcelable
{


    protected SubjectClass(Parcel in) {
    }

    public static final Creator<SubjectClass> CREATOR = new Creator<SubjectClass>() {
        @Override
        public SubjectClass createFromParcel(Parcel in) {
            return new SubjectClass(in);
        }

        @Override
        public SubjectClass[] newArray(int size) {
            return new SubjectClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
