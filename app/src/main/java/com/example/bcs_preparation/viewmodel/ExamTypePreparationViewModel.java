package com.example.bcs_preparation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bcs_preparation.model.ExamTypePreparationModel;
import com.example.bcs_preparation.repository.ExamTypePreparationRepository;

import java.util.List;

public class ExamTypePreparationViewModel extends AndroidViewModel {

    private ExamTypePreparationRepository repository;
    public ExamTypePreparationViewModel(@NonNull Application application) {
        super(application);
        repository = new ExamTypePreparationRepository(application);
    }

    public LiveData<List<ExamTypePreparationModel.Datum>> getExamTypePreparationData(){
        return repository.getExamTypePreparationData();
    }
}
