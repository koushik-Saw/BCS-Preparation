package com.example.bcs_preparation.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.UserRegistration;
import com.example.network.ApiServices;
import com.example.network.RetrofitInstance;
import com.google.gson.JsonObject;

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


    public MutableLiveData<String> regUser(String name,String phone, String password){
        MutableLiveData mutableLiveData = new MutableLiveData();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name",name);
        jsonObject.addProperty("phone",phone);
        jsonObject.addProperty("password",password);

        //jsonbody
        JsonObject jsonBody = new JsonObject();
        jsonBody.add("body",jsonObject);

        Log.e("TAG", "regUser: "+jsonBody.toString() );
        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

        apiServices.creatUser(jsonBody).enqueue(new Callback<UserRegistration.Body>() {
            @Override
            public void onResponse(Call<UserRegistration.Body> call, Response<UserRegistration.Body> response) {

                if (response.isSuccessful()){
                    mutableLiveData.postValue("Success");
                    Log.e("TAG", "onResponse: "+"Success" );
//                    Log.e("size", "onFailure: "+response.body().getData().size());
                    //hello
                }
                else if(!response.isSuccessful()){
                    mutableLiveData.postValue("User Already Exists");
                    Log.e("TAG", "onResponse: "+"User Already Exists" );
                }
            }

            @Override
            public void onFailure(Call<UserRegistration.Body> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.getLocalizedMessage() );
            }
        });

        return mutableLiveData;
    }
}
