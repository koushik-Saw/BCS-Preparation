package com.example.bcs_preparation.repository;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.UserRegistration;
import com.example.bcs_preparation.view.authentication.Login;
import com.example.bcs_preparation.view.authentication.Singup;
import com.example.network.ApiServices;
import com.example.network.RetrofitInstance;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {
    static LoginRepo loginRepo;
    static Context context;

    public static LoginRepo getLoginRepo(Context context) {
        if(loginRepo == null){
            loginRepo = new LoginRepo();
            context = context;
        }
        return loginRepo;
    }

    UserRegistration userRegistration;


    public MutableLiveData<String> logUser(String phone, String password){
        MutableLiveData mutableLiveData1 = new MutableLiveData();
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("phone",phone);
        jsonObject1.addProperty("password",password);

        //jsonbody
        JsonObject jsonBody1 = new JsonObject();
        jsonBody1.add("body",jsonObject1);

        Log.e("TAG", "regUser: "+jsonBody1.toString() );
        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
        Login Login = new Login();

        apiServices.loginUser(jsonBody1).enqueue(new Callback<UserRegistration.Body>() {
            @Override
            public void onResponse(Call<UserRegistration.Body> call, Response<UserRegistration.Body> response) {
                if (response.isSuccessful()){
                    mutableLiveData1.postValue("Success");
                    Log.e("TAG", "onResponse: "+"Login Successful");
//                  Log.e("size", "onFailure: "+response.body().getData().size());
                }
                else {
                    Log.e("TAG", "onFailure: "+"Login Failed" );
                }
            }

            @Override
            public void onFailure(Call<UserRegistration.Body> call, Throwable t) {
                Log.e("TAG", "onFailure: "+"Login Failed" );
            }
        });

        return mutableLiveData1;
    }
}
