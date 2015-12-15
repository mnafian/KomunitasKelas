package com.inagata.komunitaskelas.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created on : December 13, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class PrivateMessage implements Parcelable {

    public static final Creator<PrivateMessage> CREATOR = new Creator<PrivateMessage>() {
        @Override
        public PrivateMessage createFromParcel(Parcel in) {
            return new PrivateMessage(in);
        }

        @Override
        public PrivateMessage[] newArray(int size) {
            return new PrivateMessage[size];
        }
    };
    private String class_fullname;
    private String normal;
    private String class_time;
    private String class_message;

    protected PrivateMessage(Parcel in) {
        class_fullname = in.readString();
        normal = in.readString();
        class_time = in.readString();
        class_message = in.readString();
    }

    public String getClass_fullname() {
        return class_fullname;
    }

    public void setClass_fullname(String class_fullname) {
        this.class_fullname = class_fullname;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public String getClass_message() {
        return class_message;
    }

    public void setClass_message(String class_message) {
        this.class_message = class_message;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(class_fullname);
        dest.writeString(class_message);
        dest.writeString(class_time);
        dest.writeString(normal);
    }
}
