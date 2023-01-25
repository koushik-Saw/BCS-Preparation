package com.example.bcs_preparation.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.LiveExamTypeModel;
import com.example.bcs_preparation.network.ApiServices;
import com.example.bcs_preparation.network.RetrofitInstance;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveExamTypeRepository {
    static LiveExamTypeRepository liveExamRepo;
    static Context mContext;
    private LiveExamTypeModel liveExamTypeModel;
    private List<LiveExamTypeModel.Datum> mResult;

    public static LiveExamTypeRepository getLiveExamTypeRepo(Context context) {
        if(liveExamRepo == null){
            liveExamRepo = new LiveExamTypeRepository();
            mContext = context;
        }
        return liveExamRepo;
    }

    public MutableLiveData<List<LiveExamTypeModel.Datum>> getByParent(){
        MutableLiveData liveExamTypeMutableLiveData = new MutableLiveData<>();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id",1);

        JsonObject jsonObjectBody = new JsonObject();
        jsonObjectBody.add("body",jsonObject);
        Log.e("jsonObject", "onCreateView: "+jsonObjectBody );

        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

        apiServices.getByParent(jsonObjectBody).enqueue(new Callback<LiveExamTypeModel>() {
            @Override
            public void onResponse(Call<LiveExamTypeModel> call, Response<LiveExamTypeModel> response) {
                Log.e("isSuccessful", "onResponse: "+response);
                if(response.isSuccessful()){
//                    mResult.clear();
                    liveExamTypeModel = response.body();
                    mResult = liveExamTypeModel.getBody().getData();
                    Log.e("bcs", "onResponse: "+mResult.get(0).getName() );
                    liveExamTypeMutableLiveData.postValue(mResult);
                }
            }

            @Override
            public void onFailure(Call<LiveExamTypeModel> call, Throwable t) {
               // liveExamTypeMutableLiveData.postValue("");
                Log.e("LiveExamTypeModel", "onResponse: "+t.getLocalizedMessage());
              //  liveExamTypeMutableLiveData.postValue(mResult);

            }
        });

        return liveExamTypeMutableLiveData;
    }
}
