package com.inagata.komunitaskelas.data.api;

import com.inagata.komunitaskelas.data.model.Contact;
import com.inagata.komunitaskelas.data.model.DetailThread;
import com.inagata.komunitaskelas.data.model.PrivateMessage;
import com.inagata.komunitaskelas.data.model.SchoolClass;
import com.inagata.komunitaskelas.data.model.SubjectClass;

import java.util.List;

import id.zelory.benih.network.BenihServiceGenerator;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created on : December 12, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public enum KomunitasKelasApiSample {
    KELASAPI;
    private final API api;

    KomunitasKelasApiSample() {
        api = BenihServiceGenerator.createService(API.class, API.ENDPOINT_SAMPLE);
    }

    public static KomunitasKelasApiSample grabData() {
        return KELASAPI;
    }

    public API getAPI() {
        return api;
    }

    public interface API {

        String ENDPOINT_SAMPLE = "https://gist.githubusercontent.com/danial18/";

        @GET("/5d7158714cc2a7121e98/raw/62dc06466bdce052c7a8ccb67e5e860f8728fb11/ListClass.json")
        Observable<List<SchoolClass>> getClassList();

        @GET("/cf2c9ba15f7b85c3afaa/raw/0d3592157a92b9dda39b02e8273b43cb55e1b89f/ListSubject.json")
        Observable<List<SubjectClass>> getSubjectList();

        @GET("/124efbf9023d41bd03d7/raw/62fe5f2b5124327d608b3e24b3b189f118a7acd7/DetailPost.json")
        Observable<DetailThread> getDetailThread();

        @GET("/72ad244e8be6506cc686/raw/03890d3c15127232c79c8ac7335d4180890127bd/ListMessage.json")
        Observable<List<PrivateMessage>> getMessageList();

        @GET("/")
        Observable<List<Contact>> getContactList();

    }
}
