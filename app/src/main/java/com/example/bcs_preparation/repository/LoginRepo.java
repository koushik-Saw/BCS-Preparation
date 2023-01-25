package com.example.bcs_preparation.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.LoginModel;
import com.example.bcs_preparation.network.ApiServices;
import com.example.bcs_preparation.network.RetrofitInstance;
import com.example.bcs_preparation.preferences.AuthenticationPref;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {
    static LoginRepo loginRepo;
    static Context context;
    static AuthenticationPref authPref;

    public static LoginRepo getLoginRepo(Context context) {
        if(loginRepo == null){
            loginRepo = new LoginRepo();
            context = context;
            authPref = new AuthenticationPref(context);
        }
        return loginRepo;
    }

    public MutableLiveData<String> logUser(String userName, String password){
        MutableLiveData mutableLiveData1 = new MutableLiveData();
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("username",userName);
        jsonObject1.addProperty("password",password);

        //jsonbody
        JsonObject jsonBody1 = new JsonObject();
        jsonBody1.add("body",jsonObject1);

        Log.e("TAG", "logUser: "+jsonBody1.toString() );


        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

        apiServices.loginUser(jsonBody1).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()){
                    try {
                        mutableLiveData1.postValue("Success");
                        ConstantUtils.LiveExam.LOGIN_USER_Id = response.body().getBody().getData().get(0).getUser().getId();
                        authPref.setAccessToken(response.body().getBody().getData().get(0).getAccessToken());
                        authPref.setUserID(response.body().getBody().getData().get(0).getUser().getId());
                        Log.e("loginRepo", "onResponse: "+ConstantUtils.LiveExam.LOGIN_USER_Id);
                    }catch (Exception e){}
                }
                else {
                    mutableLiveData1.postValue("Login Failed");
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                mutableLiveData1.postValue("Login Failed "+t.getLocalizedMessage());
            }
        });

        return mutableLiveData1;
    }
}
