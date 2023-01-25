package com.example.bcs_preparation.view.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.view.Dashboard;
import com.example.bcs_preparation.viewmodel.RegistrationViewModel;

public class Singup extends AppCompatActivity {
    RegistrationViewModel viewModel;
    EditText signupphone,signupname,signuppass,signupconpass;
    String signname,signphone,signpass,signconpass;
    Button signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        signupname = findViewById(R.id.etsignupname);
        signupphone = findViewById(R.id.etsignupphone);
        signuppass = findViewById(R.id.etsignuppass);
        signupconpass = findViewById(R.id.etsignupconpass);
        signupbtn = findViewById(R.id.etsignupbtn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signname = signupname.getText().toString();
                signphone=signupphone.getText().toString();
                signpass=signuppass.getText().toString();
                signconpass=signupconpass.getText().toString();
                if(signpass.equals(signconpass)){
                    viewModel = new ViewModelProvider(Singup.this).get(RegistrationViewModel.class);
                    viewModel.regUser(signname,signphone,signpass).observe(Singup.this, new Observer<String>() {
                        @Override
                        public void onChanged(String s) {
                            if(s.equals("Success")){
                                startActivity(new Intent(getApplicationContext(), Login.class));
                                Toast.makeText(Singup.this, ""+s, Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(Singup.this, ""+s, Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });



    }


}