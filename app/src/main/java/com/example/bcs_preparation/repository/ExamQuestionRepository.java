package com.example.bcs_preparation.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.ExamQuestionModel;
import com.example.bcs_preparation.model.RankListModel;
import com.example.bcs_preparation.network.ApiServices;
import com.example.bcs_preparation.network.RetrofitInstance;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExamQuestionRepository {
    private Context mContext;
    private MutableLiveData mutableLiveData;
    private ExamQuestionModel examQuestionModel;
    private List<ExamQuestionModel.Question> questionResult;
    HashMap<String, List<ExamQuestionModel.Question__1>> questionMap = new HashMap<>();
    MutableLiveData<HashMap<String, ExamQuestionModel.Question__1>> success = new MutableLiveData<>();
    ArrayList<String> questionNameList = new ArrayList<>();
    List<ExamQuestionModel.Question__1> questionList = new ArrayList<>();

    public ExamQuestionRepository(Context context) {
        this.mContext = context;
    }

    public MutableLiveData<HashMap<String, List<ExamQuestionModel.Question__1>>> getExamQuestion(){
        try{
            mutableLiveData = new MutableLiveData();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", ConstantUtils.LiveExam.previousQuestionID);

            JsonObject jsonBody = new JsonObject();
            jsonBody.add("body",jsonObject);
            Log.e("examQues", "onFailure: hello android"+jsonBody);

            ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

            apiServices.getExamQuestion(jsonBody).enqueue(new Callback<ExamQuestionModel>() {
                @Override
                public void onResponse(Call<ExamQuestionModel> call, Response<ExamQuestionModel> response) {
                    try{
                        if(response.isSuccessful()){
                            questionMap.clear();
                            questionList.clear();
                            Log.e("examQues", "onResponse: hello" );
                            examQuestionModel = response.body();
                            questionResult = examQuestionModel.getBody().getData().get(0).getQuestions();
                            for(int i=0;i<questionResult.size();i++){
                                questionMap.put(questionResult.get(i).getName(),questionResult.get(i).getQuestions());
                            }

                            mutableLiveData.postValue(questionMap);

                        }
                    }catch (Exception e){
                        Log.e("bal", "onResponse: "+e.getLocalizedMessage() );
                    }
                }

                @Override
                public void onFailure(Call<ExamQuestionModel> call, Throwable t) {
                    Log.e("examQues", "onFailure: "+t.getLocalizedMessage() );
                }
            });
        }catch (Exception e){

        }
        return mutableLiveData;
    }

}
