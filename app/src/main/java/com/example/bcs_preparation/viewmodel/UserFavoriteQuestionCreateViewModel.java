package com.example.bcs_preparation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bcs_preparation.repository.UserFavoriteQuestionCreateRepository;

public class UserFavoriteQuestionCreateViewModel extends AndroidViewModel {
    private UserFavoriteQuestionCreateRepository repository;

    public UserFavoriteQuestionCreateViewModel(@NonNull Application application) {
        super(application);
        repository = new UserFavoriteQuestionCreateRepository();
    }

    public LiveData<String> createFavoriteQuestion(String name){
        return repository.createFavoriteQuestion(name);
    }
}
