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
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_profileFragment2);
                /*FragmentManager manager = getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main, new ProfileFragment());
                transaction.addToBackStack(null);
                transaction.commit();*/
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
       /* name = (TextView) findViewById(R.id.editTextTextPersonName3);
        goal1 = (TextView) findViewById(R.id.editTextTextPersonName2);
        goal2 = (TextView) findViewById(R.id.editTextTextPersonName4);
        goal3 = (TextView) findViewById(R.id.editTextTextPersonName5);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Goal1)) {
            goal1.setText(sharedpreferences.getString(Goal1, ""));
        }
        if (sharedpreferences.contains(Goal2)) {
            goal2.setText(sharedpreferences.getString(Goal2, ""));
        }
        if (sharedpreferences.contains(Goal3)) {
            goal3.setText(sharedpreferences.getString(Goal3, ""));
        }
        saveButton = (Button) findViewById(R.id.button9);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String e = goal1.getText().toString();
                String f = goal2.getText().toString();
                String g = goal3.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, n);
                editor.putString(Goal1, e);
                editor.putString(Goal2, f);
                editor.putString(Goal3, g);
                editor.commit();

            }
        });
        clearButton = (Button) findViewById(R.id.button10);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = (TextView) findViewById(R.id.editTextTextPersonName3);
                goal1 = (TextView) findViewById(R.id.editTextTextPersonName2);
                goal2 = (TextView) findViewById(R.id.editTextTextPersonName4);
                goal3 = (TextView) findViewById(R.id.editTextTextPersonName5);
                name.setText("");
                goal1.setText("");
                goal2.setText("");
                goal3.setText("");
            }
        });
        retrieveButton = (Button) findViewById(R.id.button11);
        retrieveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = (TextView) findViewById(R.id.editTextTextPersonName3);
                goal1 = (TextView) findViewById(R.id.editTextTextPersonName2);
                goal2 = (TextView) findViewById(R.id.editTextTextPersonName4);
                goal3 = (TextView) findViewById(R.id.editTextTextPersonName5);
                sharedpreferences = getSharedPreferences(mypreference,
                        Context.MODE_PRIVATE);

                if (sharedpreferences.contains(Name)) {
                    name.setText(sharedpreferences.getString(Name, ""));
                }
                if (sharedpreferences.contains(Goal1)) {
                    goal1.setText(sharedpreferences.getString(Goal1, ""));
                }
                if (sharedpreferences.contains(Goal2)) {
                    goal2.setText(sharedpreferences.getString(Goal2, ""));
                }
                if (sharedpreferences.contains(Goal3)) {
                    goal3.setText(sharedpreferences.getString(Goal3, ""));
                }
            }
        });
        backButton = (Button) findViewById(R.id.button11);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main, new HomeFragment());
            }
        });*/



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