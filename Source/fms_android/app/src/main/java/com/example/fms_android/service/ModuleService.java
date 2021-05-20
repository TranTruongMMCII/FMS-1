package com.example.fms_android.service;

import com.example.fms_android.model.Module;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ModuleService {
    @GET("/api/module/getAllModule")
    Call<ArrayList<Module>> getAllModules();

    @GET("/api/module/getModuleById/{moduleId}")
    Call<Module> getModuleByModuleID(@Path("moduleId") long moduleId);

    @POST("/api/module/addModule")
    Call<Module> postModule(@Body Module module);

    @DELETE("/api/module/deleteModue/{moduleId}")
    Call<ResponseBody> deleteModule(@Path("moduleId") long moduleId);
}