package com.example.testapplication;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.testapplication.ui.dashboard.DashboardFragment;
import com.example.testapplication.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    Button btnProfile;
    Button btnProg;
    Button retrieveButton;
    Button saveButton;
    Button clearButton;
    Button backButton;
    SharedPreferences sharedpreferences;
    TextView name;
    TextView goal1;
    TextView goal2;
    TextView goal3;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Goal1 = "Goal1Key";
    public static final String Goal2 = "Goal2Key";
    public static final String Goal3 = "Goal3Key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnProfile = (Button) findViewById(R.id.button8);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Profile_Activity.class);
                startActivity(myIntent);
            }
        });
        btnProg = (Button) findViewById(R.id.button3);
        btnProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_dashboard);
               /* FragmentManager manager1 = getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction1 = manager1.beginTransaction();
                transaction1.replace(R.id.nav_host_fragment_activity_main, new DashboardFragment());
                transaction1.addToBackStack(null);
                transaction1.commit();*/
            }
        });



        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }



}