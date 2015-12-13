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
    private String class_name;
    private String class_subject;
    private String class_activity;
    private String class_type;

    protected SchoolClass(Parcel in) {
        class_name = in.readString();
        class_subject = in.readString();
        class_activity = in.readString();
        class_type = in.readString();
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_subject() {
        return class_subject;
    }

    public void setClass_subject(String class_subject) {
        this.class_subject = class_subject;
    }

    public String getClass_activity() {
        return class_activity;
    }

    public void setClass_activity(String class_activity) {
        this.class_activity = class_activity;
    }

    public String getClass_type() {
        return class_type;
    }

    public void setClass_type(String class_type) {
        this.class_type = class_type;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(class_name);
        dest.writeString(class_subject);
        dest.writeString(class_activity);
        dest.writeString(class_type);
    }
}
