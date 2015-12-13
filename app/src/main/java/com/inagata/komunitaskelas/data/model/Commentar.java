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
public class Commentar implements Parcelable {

    public static final Creator<Commentar> CREATOR = new Creator<Commentar>() {
        @Override
        public Commentar createFromParcel(Parcel in) {
            return new Commentar(in);
        }

        @Override
        public Commentar[] newArray(int size) {
            return new Commentar[size];
        }
    };
    private String user_photos;
    private String class_fullname;
    private String class_timepost;
    private String class_jmlhvote;
    private String status_voted;
    private String class_isicoment;

    protected Commentar(Parcel in) {
        this.user_photos = in.readString();
        this.class_fullname = in.readString();
        this.class_timepost = in.readString();
        this.class_jmlhvote = in.readString();
        this.status_voted = in.readString();
        this.class_isicoment = in.readString();
    }

    public String getUser_photos() {
        return user_photos;
    }

    public void setUser_photos(String user_photos) {
        this.user_photos = user_photos;
    }

    public String getClass_fullname() {
        return class_fullname;
    }

    public void setClass_fullname(String class_fullname) {
        this.class_fullname = class_fullname;
    }

    public String getClass_timepost() {
        return class_timepost;
    }

    public void setClass_timepost(String class_timepost) {
        this.class_timepost = class_timepost;
    }

    public String getClass_jmlhvote() {
        return class_jmlhvote;
    }

    public void setClass_jmlhvote(String class_jmlhvote) {
        this.class_jmlhvote = class_jmlhvote;
    }

    public String getStatus_voted() {
        return status_voted;
    }

    public void setStatus_voted(String status_voted) {
        this.status_voted = status_voted;
    }

    public String getClass_isicoment() {
        return class_isicoment;
    }

    public void setClass_isicoment(String class_isicoment) {
        this.class_isicoment = class_isicoment;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_photos);
        dest.writeString(class_fullname);
        dest.writeString(class_timepost);
        dest.writeString(class_jmlhvote);
        dest.writeString(status_voted);
        dest.writeString(class_isicoment);
    }
}
