package com.example.bcs_preparation.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.RankListModel;
import com.example.bcs_preparation.network.ApiServices;
import com.example.bcs_preparation.network.RetrofitInstance;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankListRepository {
    private Context mContext;
    private MutableLiveData mutableLiveData;
    private RankListModel rankListModel;
    private List<RankListModel.Datum> result;

    public RankListRepository(Context context) {
        this.mContext = context;
    }

    public MutableLiveData<List<RankListModel.Datum>> getRankList(){
        try {
            mutableLiveData = new MutableLiveData();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", ConstantUtils.LiveExam.previousQuestionID);

            JsonObject jsonObjectBody = new JsonObject();
            jsonObjectBody.add("body",jsonObject);

            ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
            apiServices.getRankList(jsonObjectBody).enqueue(new Callback<RankListModel>() {
                @Override
                public void onResponse(Call<RankListModel> call, Response<RankListModel> response) {
                    if(response.isSuccessful()){
                        rankListModel = response.body();
                        result = rankListModel.getBody().getData();
                        mutableLiveData.postValue(result);
                        //Log.e("rankList", "onFailure: "+result.get(0).getMarks().toString() );
                    }
                }

                @Override
                public void onFailure(Call<RankListModel> call, Throwable t) {
                    Log.e("rankList", "onFailure: "+t.getLocalizedMessage() );
                }
            });
        }catch (Exception e){}



        return mutableLiveData;
    }
}
