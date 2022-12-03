package com.example.bcs_preparation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bcs_preparation.model.TodayExamByTypeLiveExamRoutineModel;
import com.example.bcs_preparation.repository.TodayExamByTypeLiveExamRoutineRepository;

import java.util.List;

public class TodayExamByTypeLiveExamRoutineViewModel extends AndroidViewModel{

    private TodayExamByTypeLiveExamRoutineRepository repository;

    public TodayExamByTypeLiveExamRoutineViewModel(@NonNull Application application) {
        super(application);

        repository = new TodayExamByTypeLiveExamRoutineRepository(application);
    }

    public LiveData<List<TodayExamByTypeLiveExamRoutineModel.Datum>> getTodayExamByTypeLiveExamRoutineModel(){
        return repository.getTodayExamByTypeLiveExamRoutineModel();
    }

    public LiveData<List<TodayExamByTypeLiveExamRoutineModel.Datum>> getPreviousExamByType(){
        return repository.getPreviousExamByType();
    }


}


