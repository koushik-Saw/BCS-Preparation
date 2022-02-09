package com.example.network;

import com.example.bcs_preparation.model.UserRegistration;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {


    @POST("users/create/")
    Call<UserRegistration.Body> creatUser(@Body JsonObject jsonObject);


    @POST("users/login/")
    Call<UserRegistration.Body> loginUser(@Body JsonObject jsonObject);
}
