package com.example.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testapplication.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    Button btnProfile;
    Button btnProg;
    Button btnGoals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnProfile = findViewById(R.id.button8);
        btnProfile.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, Profile_Activity.class);
            startActivity(myIntent);
        });

        btnProg = findViewById(R.id.button3);
        btnProg.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_dashboard));

        btnGoals = findViewById(R.id.button4);
        btnGoals.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddingHours.class);
            startActivity(intent);
        });



        /*BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);*/
    }



}