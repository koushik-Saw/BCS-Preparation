package com.example.bcs_preparation.view.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.view.Dashboard;
import com.example.bcs_preparation.view.MainActivity;
import com.example.bcs_preparation.viewmodel.LoginViewModel;
import com.example.bcs_preparation.viewmodel.RegistrationViewModel;

public class Login extends AppCompatActivity {
    LoginViewModel loginViewModel;
    EditText logphone,logpass;
    String phone,pass;
    Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logphone = findViewById(R.id.etLoginphone);
        logpass = findViewById(R.id.etLoginpass);

        loginbtn  = findViewById(R.id.etloginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = logphone.getText().toString();
                pass = logpass.getText().toString();
                loginViewModel = new ViewModelProvider(Login.this).get(LoginViewModel.class);
                loginViewModel.logUser2(phone,pass).observe(Login.this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
            }
        });


    }
}