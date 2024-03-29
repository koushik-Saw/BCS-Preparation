package com.example.bcs_preparation.network;

import com.example.bcs_preparation.model.ExamQuestionModel;
import com.example.bcs_preparation.model.ExamTypePreparationModel;
import com.example.bcs_preparation.model.FavouriteQuestionPlaylistModel;
import com.example.bcs_preparation.model.LiveExamTypeModel;
import com.example.bcs_preparation.model.LoginModel;
import com.example.bcs_preparation.model.RankListModel;
import com.example.bcs_preparation.model.TodayExamByTypeLiveExamRoutineModel;
import com.example.bcs_preparation.model.UserFavoriteQuestionCreateModel;
import com.example.bcs_preparation.model.UserRegistration;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {


    @POST("users/create/")
    Call<UserRegistration.Body> creatUser(@Body JsonObject jsonObject);


    @POST("authentication/login/")
    Call<LoginModel> loginUser(@Body JsonObject jsonObject);

    @POST("users/get-list/")
    Call<UserRegistration.Body> getUser(@Path("phone") String phone);

    @POST("live_exam_type/get-by-parent")
    Call<LiveExamTypeModel> getByParent(@Body JsonObject jsonObject);

    @POST("live_exam_type/get-by-parent")
    Call<ExamTypePreparationModel> getExamTypePreparationData(@Body JsonObject jsonObject);

    @POST("live_exam/get-today-exam-by-exam-type")
    Call<TodayExamByTypeLiveExamRoutineModel> getTodayExamByTypeLiveExamRoutineModel(@Body JsonObject jsonObject);

    @POST("live_exam/get-previous-by-exam-type")
    Call<TodayExamByTypeLiveExamRoutineModel> getPreviousExamByType(@Body JsonObject jsonObject);

    @POST("live_exam_result/get-by-exam-id")
    Call<RankListModel> getRankList(@Body JsonObject jsonObject);

    @POST("live_exam/get-question-by-exam")
    Call<ExamQuestionModel> getExamQuestion(@Body JsonObject jsonObject);

    @POST("user_favourite_question/get-by-user")
    Call<FavouriteQuestionPlaylistModel> getFavoriteQuestionPlayListName(@Body JsonObject jsonObject);

    @POST("user_favourite_question/create")
    Call<UserFavoriteQuestionCreateModel> createFavoriteQuestion(@Body JsonObject jsonObject);

}
