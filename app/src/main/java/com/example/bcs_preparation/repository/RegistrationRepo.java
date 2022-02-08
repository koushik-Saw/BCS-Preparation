package com.example.bcs_preparation.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.UserRegistration;
import com.example.network.ApiServices;
import com.example.network.RetrofitInstance;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationRepo {
    static RegistrationRepo repo;
    static Context context;

    public static RegistrationRepo getRegistrationRepo(Context context) {
        if(repo == null){
            repo = new RegistrationRepo();
            context = context;
        }
        return repo;
    }

    UserRegistration userRegistration;

    public MutableLiveData<List<UserRegistration.Body>> regUser(String name,String phone, String password){
        MutableLiveData mutableLiveData = new MutableLiveData();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name",name);
        jsonObject.addProperty("phone",phone);
        jsonObject.addProperty("password",password);
        Log.e("TAG", "regUser: "+jsonObject.toString() );
        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

        apiServices.creatUser(jsonObject).enqueue(new Callback<List<UserRegistration.Body>>() {
            @Override
            public void onResponse(Call<List<UserRegistration.Body>> call, Response<List<UserRegistration.Body>> response) {
                Log.e("TAG", "onFailure: "+response.body().toString() );
                if (response.isSuccessful()){
                    mutableLiveData.postValue("Success");
                    Log.e("TAG", "onResponse: "+"Success" );
                }
            }

            @Override
            public void onFailure(Call<List<UserRegistration.Body>> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.getLocalizedMessage() );
            }

        });

        return mutableLiveData;
    }
}
