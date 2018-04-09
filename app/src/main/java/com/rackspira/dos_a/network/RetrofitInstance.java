package com.rackspira.dos_a.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anang S on 09/04/2018.
 */

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "di isi link";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null ){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }
}
