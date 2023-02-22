package com.example.bcs_preparation.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.UserFavoriteQuestionCreateModel;
import com.example.bcs_preparation.network.ApiServices;
import com.example.bcs_preparation.network.RetrofitInstance;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFavoriteQuestionCreateRepository {

    public MutableLiveData<String> createFavoriteQuestion(String name){
        MutableLiveData mutableLiveData1 = new MutableLiveData();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", ConstantUtils.LiveExam.LOGIN_USER_Id);
        jsonObject.addProperty("name",name);

        JsonObject jsonBody = new JsonObject();
        jsonBody.add("body",jsonObject);

        Log.e("jsonBody", "createFavoriteQuestion: "+jsonBody );

        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

        apiServices.createFavoriteQuestion(jsonBody).enqueue(new Callback<UserFavoriteQuestionCreateModel>() {
            @Override
            public void onResponse(Call<UserFavoriteQuestionCreateModel> call, Response<UserFavoriteQuestionCreateModel> response) {
                try{
                    if(response.isSuccessful()){
                        Log.e("details", "onResponse: "+response.body().getBody().getName() );
                        mutableLiveData1.postValue("Success");
                    }else {
                        mutableLiveData1.postValue("Failed");
                    }
                }catch (Exception e){}

            }

            @Override
            public void onFailure(Call<UserFavoriteQuestionCreateModel> call, Throwable t) {
                Log.e("localizedMessage", "onFailure: "+t.getLocalizedMessage() );
            }
        });

        return mutableLiveData1;
    }
}
