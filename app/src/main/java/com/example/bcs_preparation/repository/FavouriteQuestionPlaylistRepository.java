package com.example.bcs_preparation.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.model.FavouriteQuestionPlaylistModel;
import com.example.bcs_preparation.network.ApiServices;
import com.example.bcs_preparation.network.RetrofitInstance;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavouriteQuestionPlaylistRepository {
    private Context context;
    private MutableLiveData mutableLiveData;
    private FavouriteQuestionPlaylistModel favouriteQuestionPlaylistModel;
    private List<FavouriteQuestionPlaylistModel.Datum> playList = new ArrayList<>();

    public FavouriteQuestionPlaylistRepository(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<FavouriteQuestionPlaylistModel.Datum>> getFavoriteQuestionPlayListName(){
        mutableLiveData = new MutableLiveData();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", ConstantUtils.LiveExam.LOGIN_USER_Id);

        JsonObject jsonObjectBody = new JsonObject();
        jsonObjectBody.add("body",jsonObject);

        Log.e("favoriteQuestionName", "getFavoriteQuestionPlayListName: "+jsonObjectBody.toString());

        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);

        apiServices.getFavoriteQuestionPlayListName(jsonObjectBody).enqueue(new Callback<FavouriteQuestionPlaylistModel>() {
            @Override
            public void onResponse(Call<FavouriteQuestionPlaylistModel> call, Response<FavouriteQuestionPlaylistModel> response) {
                try {
                    Log.e("favoriteQuestionName", "onResponse: hello" );
                    if(response.isSuccessful()){
                        Log.e("favoriteQuestionName", "onResponse: hello1" );
                        playList.clear();
                        favouriteQuestionPlaylistModel = response.body();
                        for(int i=0;i<response.body().getBody().getData().size();i++){
                            playList.add(response.body().getBody().getData().get(i));
                        }


                        mutableLiveData.postValue(playList);

                    }else {
                        Log.e("favoriteQuestionName", "onResponse: hello5" );
                    }
                }catch (Exception e){
                    Log.e("favoriteQuestionName", "onResponse: hello2 "+e.getLocalizedMessage() );
                }
            }

            @Override
            public void onFailure(Call<FavouriteQuestionPlaylistModel> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
