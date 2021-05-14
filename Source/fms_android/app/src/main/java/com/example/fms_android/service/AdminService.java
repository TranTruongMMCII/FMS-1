package com.example.fms_android.service;

import com.example.fms_android.model.Admin;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AdminService {
    @GET("api/admin/getAllAdmin")
    Call<ArrayList<Admin>> getAdmins();

    @GET("api/admin/getAdminById/{userName}")
    Call<Admin> getAnswersByUsername(@Path("userName") String userName);

    @POST("api/admin/addAdmin")
    Call<Admin> postAdmin(@Body Admin admin);

    @GET("api/admin/getAdmin/{userName}/{password}")
    Call<Admin> getAdmin(@Path("userName") String userName, @Path("password") String password);
}
