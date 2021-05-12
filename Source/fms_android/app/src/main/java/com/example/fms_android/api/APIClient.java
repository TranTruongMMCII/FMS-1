package com.example.fms_android.api;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public  static  Retrofit retrofit = null;

    public static Retrofit getClient(String baseURL){
        retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }
}
