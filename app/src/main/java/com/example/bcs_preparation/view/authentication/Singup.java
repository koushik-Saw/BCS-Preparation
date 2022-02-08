package com.example.bcs_preparation.view.authentication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.viewmodel.RegistrationViewModel;

public class Singup extends AppCompatActivity {
    RegistrationViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        ///jhnujuj

        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        viewModel.regUser2("D","99955533313","123456").observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("tag", "onChanged: "+s);
            }
        });
    }


}