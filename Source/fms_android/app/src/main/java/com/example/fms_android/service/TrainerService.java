package com.example.fms_android.service;

import com.example.fms_android.model.Trainer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TrainerService {
    @GET("api/trainer/getAllTrainer")
    Call<ArrayList<Trainer>> getTrainers();

    @GET("api/trainer/getTrainerById/{userName}")
    Call<Trainer> getAnswersByUsername(@Path("userName") String userName);

    @POST("api/trainer/addTrainer")
    Call<Trainer> postTrainer(@Body Trainer trainer);
}

