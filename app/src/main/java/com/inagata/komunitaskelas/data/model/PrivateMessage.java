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
    private String namePerson;
    private String statusLastMessage;

    protected PrivateMessage(Parcel in) {
        namePerson = in.readString();
        statusLastMessage = in.readString();
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getStatusLastMessage() {
        return statusLastMessage;
    }

    public void setStatusLastMessage(String statusLastMessage) {
        this.statusLastMessage = statusLastMessage;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namePerson);
        dest.writeString(statusLastMessage);
    }
}
