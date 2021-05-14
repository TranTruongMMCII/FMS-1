package com.example.fms_android.service;

import com.example.fms_android.model.Trainee;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TraineeService {
    @GET("api/trainee/getAllTrainee")
    Call<ArrayList<Trainee>> getTrainees();

    @GET("api/trainee/getTraineeById/{userName}")
    Call<Trainee> getAnswersByUsername(@Path("userName") String userName);

    @POST("api/trainee/addTrainee")
    Call<Trainee> postTrainee(@Body Trainee trainee);
}

