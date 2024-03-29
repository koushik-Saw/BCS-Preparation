package com.example.bcs_preparation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bcs_preparation.repository.RegistrationRepo;

public class RegistrationViewModel extends AndroidViewModel {
    RegistrationRepo repo ;
    LiveData mutableLiveData2;

    public RegistrationViewModel(@NonNull Application application) {
        super(application);
        repo = RegistrationRepo.getRegistrationRepo(application);
    }

    public LiveData<String> regUser(String name,String phone, String password){
        return repo.regUser(name, phone, password);
    }
}
