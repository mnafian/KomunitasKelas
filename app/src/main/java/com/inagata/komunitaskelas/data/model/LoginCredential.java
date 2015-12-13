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
public class LoginCredential implements Parcelable{

    public static final Creator<LoginCredential> CREATOR = new Creator<LoginCredential>()
    {
        @Override
        public LoginCredential createFromParcel(Parcel in)
        {
            return new LoginCredential(in);
        }

        @Override
        public LoginCredential[] newArray(int size)
        {
            return new LoginCredential[size];
        }
    };
    private String error;
    private String email;
    private String message;
    private String api_key;
    private String idSchool;

    public LoginCredential(Parcel in) {
        error = in.readString();
        email = in.readString();
        message = in.readString();
        api_key = in.readString();
        idSchool = in.readString();
    }

    public LoginCredential() {

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiKey() {
        return api_key;
    }

    public void setApiKey(String apiKey) {
        this.api_key = apiKey;
    }

    public String getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(String idSchool) {
        this.idSchool = idSchool;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(error);
        dest.writeString(email);
        dest.writeString(message);
        dest.writeString(api_key);
        dest.writeString(idSchool);
    }
}
