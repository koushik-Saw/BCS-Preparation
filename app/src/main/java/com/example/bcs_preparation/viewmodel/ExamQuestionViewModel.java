package com.example.bcs_preparation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bcs_preparation.model.ExamQuestionModel;
import com.example.bcs_preparation.repository.ExamQuestionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExamQuestionViewModel extends AndroidViewModel {
    private ExamQuestionRepository repository;

    public ExamQuestionViewModel(@NonNull Application application) {
        super(application);
        repository = new ExamQuestionRepository(application);
    }

    public LiveData<HashMap<String, List<ExamQuestionModel.Question__1>>> getExamQuestion(){
        return repository.getExamQuestion();
    }


}
