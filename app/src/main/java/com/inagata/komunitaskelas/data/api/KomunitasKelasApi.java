package com.inagata.komunitaskelas.data.api;

import com.inagata.komunitaskelas.data.api.response.ListResponse;
import com.inagata.komunitaskelas.data.model.LoginCredential;
import com.inagata.komunitaskelas.data.model.Register;
import com.inagata.komunitaskelas.data.model.SchoolClass;

import id.zelory.benih.network.BenihServiceGenerator;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
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

    public API getAPI() {
        return api;
    }

    public interface API {
        String ENDPOINT = "http://dev.inagata.com/hack-gata/v1";

        @FormUrlEncoded
        @POST("/login")
        Observable<LoginCredential> doLogin(@Field("email") String email, @Field("password") String password);

        @POST("/class")
        Observable<ListResponse<SchoolClass>> addClass(@Field("name") String name, @Field("subject") String subject, @Field("id_school") String idSchool);

        @POST("/register")
        Observable<Register> registerUser(@Field("full_name") String fullName, @Field("id_status") String idStatus, @Field("id_state") String idState, @Field("ic_city") String idCity, @Field("id_school") String idSchool, @Field("email") String email, @Field("password") String idPassword);

    }
}
