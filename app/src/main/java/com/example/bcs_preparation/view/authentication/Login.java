package com.example.bcs_preparation.view.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.databinding.ActivityLoginBinding;
import com.example.bcs_preparation.preferences.AuthenticationPref;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.example.bcs_preparation.view.Dashboard;
import com.example.bcs_preparation.view.MainActivity;
import com.example.bcs_preparation.viewmodel.LoginViewModel;
import com.example.bcs_preparation.viewmodel.RegistrationViewModel;

public class Login extends AppCompatActivity {
    LoginViewModel loginViewModel;
    String phone,pass;
    private ProgressDialog progressDialog;
    private ActivityLoginBinding binding;
    private AuthenticationPref authPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        authPref = new AuthenticationPref(this);

        if(authPref.getLoginStatus()){
            goToMainActivity();
        }

        binding.etloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    progressDialog = new ProgressDialog(Login.this);
                    progressDialog.setMessage("Loading");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    phone = binding.etLoginphone.getText().toString();
                    pass = binding.etLoginpass.getText().toString();
                    loginViewModel = new ViewModelProvider(Login.this).get(LoginViewModel.class);
                    loginViewModel.loginUser(phone,pass).observe(Login.this, new Observer<String>() {
                        @Override
                        public void onChanged(String s) {
                            if(s.equals("Success")){
                                authPref.setLoginStatus(true);
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                goToMainActivity();

                            }else {
                                progressDialog.dismiss();
                                Toast.makeText(Login.this, ""+s, Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

                }catch (Exception e){}


            }
        });

        binding.registrationTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Singup.class));
                finish();
            }
        });


    }

    private void goToMainActivity() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}