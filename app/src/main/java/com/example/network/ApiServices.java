package com.example.network;

import com.example.bcs_preparation.model.UserRegistration;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {


    @POST("users/create/")
    Call<UserRegistration.Body> creatUser(@Body JsonObject jsonObject);


    @POST("users/login/")
    Call<UserRegistration.Body> loginUser(@Body JsonObject jsonObject);

    @POST("users/get-list/")
    Call<UserRegistration.Body> getUser(@Path("phone") String phone);

}
