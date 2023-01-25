package com.example.bcs_preparation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.databinding.ActivityMainBinding;
import com.example.bcs_preparation.preferences.AuthenticationPref;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageMenu;
    private TextView title;
    private AuthenticationPref authPref;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        imageMenu = findViewById(R.id.imageMenu);
        title = findViewById(R.id.title);
        authPref = new AuthenticationPref(this);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        binding.navView.setItemIconTintList(null);
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(binding.navView,navController);

        ConstantUtils.AuthPreference.ACCESS_TOKEN = authPref.getAccessToken();
        //Log.e("accessToken", "onCreate: "+ConstantUtils.AuthPreference.ACCESS_TOKEN );


    }


}