package com.example.bcs_preparation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bcs_preparation.model.RankListModel;
import com.example.bcs_preparation.repository.RankListRepository;

import java.util.List;

public class RankListViewModel extends AndroidViewModel {
    private RankListRepository repository;
    public RankListViewModel(@NonNull Application application) {
        super(application);

        repository = new RankListRepository(application);
    }

    public LiveData<List<RankListModel.Datum>> getRankList(){
        return repository.getRankList();
    }
}
