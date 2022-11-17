package com.example.bcs_preparation.network;

import com.example.bcs_preparation.model.ExamTypePreparationModel;
import com.example.bcs_preparation.model.LiveExamTypeModel;
import com.example.bcs_preparation.model.LoginModel;
import com.example.bcs_preparation.model.UserRegistration;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {


    @POST("users/create/")
    Call<UserRegistration.Body> creatUser(@Body JsonObject jsonObject);


    @POST("authentication/login/")
    Call<LoginModel> loginUser(@Body JsonObject jsonObject);

    @POST("users/get-list/")
    Call<UserRegistration.Body> getUser(@Path("phone") String phone);

    @POST("live_exam_type/get-by-parent")
    Call<LiveExamTypeModel> getByParent(@Body JsonObject jsonObject);

    @POST("live_exam_type/get-by-parent")
    Call<ExamTypePreparationModel> getExamTypePreparationData(@Body JsonObject jsonObject);


}
