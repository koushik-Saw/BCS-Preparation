package com.example.bcs_preparation.view.authentication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.model.UserRegistration;
import com.example.bcs_preparation.viewmodel.RegistrationViewModel;

import java.util.List;

public class Singup extends AppCompatActivity {
    RegistrationViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        viewModel.regUser2("D","01878077913","123456").observe(this, new Observer<UserRegistration.Body>() {
            @Override
            public void onChanged(UserRegistration.Body body) {

            }
        });
    }


}