package com.inagata.komunitaskelas.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created on : December 13, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class DetailThread implements Parcelable {

    public static final Creator<DetailThread> CREATOR = new Creator<DetailThread>() {
        @Override
        public DetailThread createFromParcel(Parcel in) {
            return new DetailThread(in);
        }

        @Override
        public DetailThread[] newArray(int size) {
            return new DetailThread[size];
        }
    };
    private String user_photos;
    private String detail_fullname;
    private String class_timepost;
    private String class_jmlhvote;
    private String class_title;
    private String status_voted;
    private String class_deskripsi;
    private List<Commentar> class_comment;

    protected DetailThread(Parcel in) {
        this.user_photos = in.readString();
        this.detail_fullname = in.readString();
        this.class_timepost = in.readString();
        this.class_jmlhvote = in.readString();
        this.class_title = in.readString();
        this.status_voted = in.readString();
        this.class_deskripsi = in.readString();
        this.class_comment = in.createTypedArrayList(Commentar.CREATOR);
    }

    public String getUser_photos() {
        return user_photos;
    }

    public void setUser_photos(String user_photos) {
        this.user_photos = user_photos;
    }

    public String getDetail_fullname() {
        return detail_fullname;
    }

    public void setDetail_fullname(String detail_fullname) {
        this.detail_fullname = detail_fullname;
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

    public String getClass_title() {
        return class_title;
    }

    public void setClass_title(String class_title) {
        this.class_title = class_title;
    }

    public String getStatus_voted() {
        return status_voted;
    }

    public void setStatus_voted(String status_voted) {
        this.status_voted = status_voted;
    }

    public String getClass_deskripsi() {
        return class_deskripsi;
    }

    public void setClass_deskripsi(String class_deskripsi) {
        this.class_deskripsi = class_deskripsi;
    }

    public List<Commentar> getClass_comment() {
        return class_comment;
    }

    public void setClass_comment(List<Commentar> class_comment) {
        this.class_comment = class_comment;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_photos);
        dest.writeString(detail_fullname);
        dest.writeString(class_timepost);
        dest.writeString(class_jmlhvote);
        dest.writeString(class_title);
        dest.writeString(status_voted);
        dest.writeString(class_deskripsi);
        dest.writeTypedList(class_comment);
    }
}
