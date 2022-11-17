package com.example.bcs_preparation.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.ExamTypePreparationModel;
import com.example.bcs_preparation.model.LiveExamTypeModel;
import com.example.bcs_preparation.network.ApiServices;
import com.example.bcs_preparation.network.RetrofitInstance;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExamTypePreparationRepository {
    private Context context;
    private MutableLiveData mutableLiveData;
    private ExamTypePreparationModel examTypePreparationModel;
    private List<ExamTypePreparationModel.Datum> result;

    public ExamTypePreparationRepository(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<ExamTypePreparationModel.Datum>> getExamTypePreparationData(){
        mutableLiveData = new MutableLiveData();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", ConstantUtils.LiveExam.LIVE_EXAM_Id);

        JsonObject jsonObjectBody = new JsonObject();
        jsonObjectBody.add("body",jsonObject);
        Log.e("jsonObject", "onCreateView: "+jsonObjectBody );

        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
        apiServices.getExamTypePreparationData(jsonObjectBody).enqueue(new Callback<ExamTypePreparationModel>() {
            @Override
            public void onResponse(Call<ExamTypePreparationModel> call, Response<ExamTypePreparationModel> response) {
                if(response.isSuccessful()){
                    examTypePreparationModel = response.body();
                    result = examTypePreparationModel.getBody().getData();
                    mutableLiveData.postValue(result);
                }
            }

            @Override
            public void onFailure(Call<ExamTypePreparationModel> call, Throwable t) {
                Toast.makeText(context, "failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });

        return mutableLiveData;
    }
}
