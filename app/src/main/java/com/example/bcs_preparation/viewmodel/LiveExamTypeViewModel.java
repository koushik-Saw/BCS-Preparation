package com.example.bcs_preparation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bcs_preparation.model.LiveExamTypeModel;
import com.example.bcs_preparation.repository.LiveExamTypeRepository;

import java.util.List;

public class LiveExamTypeViewModel extends AndroidViewModel {

    private LiveExamTypeRepository repository;
    public LiveExamTypeViewModel(@NonNull Application application) {
        super(application);
        repository = LiveExamTypeRepository.getLiveExamTypeRepo(application);
    }

    public LiveData<List<LiveExamTypeModel.Datum>> getByParent(){
        return repository.getByParent();
    }
}
