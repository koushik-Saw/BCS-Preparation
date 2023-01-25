package com.example.bcs_preparation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.bcs_preparation.repository.FavouriteQuestionPlaylistRepository;

import java.util.List;

public class FavouriteQuestionPlaylistViewModel extends AndroidViewModel {
    private FavouriteQuestionPlaylistRepository repository;
    public FavouriteQuestionPlaylistViewModel(@NonNull Application application) {
        super(application);

        repository = new FavouriteQuestionPlaylistRepository(application);
    }

    public MutableLiveData<List<String>> getFavoriteQuestionPlayListName(){
        return repository.getFavoriteQuestionPlayListName();
    }
}
