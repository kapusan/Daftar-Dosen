package com.rackspira.dos_a.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anang S on 09/04/2018.
 */

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://dosen.rackspira.id/API/";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null ){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }
}
