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
    private String class_title;
    private String class_jmlhcoment;
    private String class_time;
    private String class_pin;

    protected SubjectClass(Parcel in) {
        this.class_title = in.readString();
        this.class_jmlhcoment = in.readString();
        this.class_time = in.readString();
        this.class_pin = in.readString();
    }

    public String getClass_title() {
        return class_title;
    }

    public void setClass_title(String class_title) {
        this.class_title = class_title;
    }

    public String getClass_jmlhcoment() {
        return class_jmlhcoment;
    }

    public void setClass_jmlhcoment(String class_jmlhcoment) {
        this.class_jmlhcoment = class_jmlhcoment;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public String getClass_pin() {
        return class_pin;
    }

    public void setClass_pin(String class_pin) {
        this.class_pin = class_pin;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(class_title);
        dest.writeString(class_jmlhcoment);
        dest.writeString(class_pin);
        dest.writeString(class_time);
    }
}
