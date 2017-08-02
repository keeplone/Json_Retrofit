package com.example.zensea.json_retrofit2.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zensea on 02-Aug-17.
 */

public class Client {

    public static final String BASE_url = "http://www.office365thailand.com";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit ==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
