package com.example.bcs_preparation.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.TodayExamByTypeLiveExamRoutineModel;
import com.example.bcs_preparation.network.ApiServices;
import com.example.bcs_preparation.network.RetrofitInstance;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodayExamByTypeLiveExamRoutineRepository {

    private Context context;
    private MutableLiveData mutableLiveData;
    private TodayExamByTypeLiveExamRoutineModel todayExamByTypeLiveExamRoutineModel;
    private List<TodayExamByTypeLiveExamRoutineModel.Datum> result;

    public TodayExamByTypeLiveExamRoutineRepository(Context context) {
        this.context = context;
    }


    public MutableLiveData<List<TodayExamByTypeLiveExamRoutineModel.Datum>> getTodayExamByTypeLiveExamRoutineModel(){

        mutableLiveData = new MutableLiveData();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", ConstantUtils.LiveExam.LIVE_EXAM_ROUTINE);

        JsonObject jsonObjectBody = new JsonObject();
        jsonObjectBody.add("body",jsonObject);

        Log.e("jsonObjectBody", "getTodayExamByTypeLiveExamRoutineModel: "+jsonObjectBody);
        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

        apiServices.getTodayExamByTypeLiveExamRoutineModel(jsonObjectBody).enqueue(new Callback<TodayExamByTypeLiveExamRoutineModel>() {
            @Override
            public void onResponse(Call<TodayExamByTypeLiveExamRoutineModel> call, Response<TodayExamByTypeLiveExamRoutineModel> response) {
                if(response.isSuccessful()){
                    todayExamByTypeLiveExamRoutineModel = response.body();
                    result = todayExamByTypeLiveExamRoutineModel.getBody().getData();
                    mutableLiveData.postValue(result);
                    Log.e("resSize", "onResponse: size "+response.body().getBody().getData().size() );
                }

            }

            @Override
            public void onFailure(Call<TodayExamByTypeLiveExamRoutineModel> call, Throwable t) {
                Log.e("error", "onFailure: "+t.getLocalizedMessage() );
            }
        });

        return mutableLiveData;

    }


    public MutableLiveData<List<TodayExamByTypeLiveExamRoutineModel.Datum>> getPreviousExamByType(){

        mutableLiveData = new MutableLiveData();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", ConstantUtils.LiveExam.LIVE_EXAM_ROUTINE);

        JsonObject jsonObjectBody = new JsonObject();
        jsonObjectBody.add("body",jsonObject);

        Log.e("jsonObjectBody", "getTodayExamByTypeLiveExamRoutineModel: "+jsonObjectBody);
        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

        apiServices.getPreviousExamByType(jsonObjectBody).enqueue(new Callback<TodayExamByTypeLiveExamRoutineModel>() {
            @Override
            public void onResponse(Call<TodayExamByTypeLiveExamRoutineModel> call, Response<TodayExamByTypeLiveExamRoutineModel> response) {
                try{
                    if(response.isSuccessful()){
                        todayExamByTypeLiveExamRoutineModel = response.body();
                        result = todayExamByTypeLiveExamRoutineModel.getBody().getData();
                        mutableLiveData.postValue(result);
                    }
                }catch (Exception e){}


            }

            @Override
            public void onFailure(Call<TodayExamByTypeLiveExamRoutineModel> call, Throwable t) {
                Log.e("error", "onFailure: "+t.getLocalizedMessage() );
            }
        });

        return mutableLiveData;

    }

}
