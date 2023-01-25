package com.example.bcs_preparation.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bcs_preparation.repository.LoginRepo;

public class LoginViewModel extends AndroidViewModel {
    LoginRepo loginRepo ;
    LiveData mutableLiveData2;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepo = LoginRepo.getLoginRepo(application);
    }

    public LiveData<String> loginUser(String userName, String password){
        return loginRepo.logUser(userName, password);
    }
}
