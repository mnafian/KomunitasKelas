package com.inagata.komunitaskelas.data.api;

import com.inagata.komunitaskelas.data.api.response.ListResponse;
import com.inagata.komunitaskelas.data.model.LoginCredential;
import com.inagata.komunitaskelas.data.model.SchoolClass;
import com.inagata.komunitaskelas.data.model.SubjectClass;

import id.zelory.benih.network.BenihServiceGenerator;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created on : December 10, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public enum KomunitasKelasApi
{
    KELASAPI;
    private final API api;

    KomunitasKelasApi() {
        api = BenihServiceGenerator.createService(API.class, API.ENDPOINT);
    }

    public static KomunitasKelasApi grabData(){
        return KELASAPI;
    }

    public interface API {
        String ENDPOINT = "http://dev.inagata.com/hack-gata/v1";

        @FormUrlEncoded
        @POST("/login")
        Observable<ListResponse<LoginCredential>> doLogin(@Field("email") String email, @Field("password") String password);

        @POST("/class")
        Observable<ListResponse<SchoolClass>> addClass(@Field("name") String name, @Field("subject") String subject, @Field("id_school") String idSchool);

        @GET("/subject")
        Observable<ListResponse<SubjectClass>> getSubject();

    }

    public API getAPI() {
        return api;
    }
}
