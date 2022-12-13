package com.example.testapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Profile_Activity extends AppCompatActivity {
    Button retrieveButton;
    Button saveButton;
    Button clearButton;
    Button backButton;
    Button HoursBtn;
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
    private Button btnToggleDark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.editTextTextPersonName3);
        goal1 = findViewById(R.id.editTextTextPersonName2);
        goal2 = findViewById(R.id.editTextTextPersonName4);
        goal3 = findViewById(R.id.editTextTextPersonName5);
        // commented out as it would not let you update goal names with this active fixed just press clear first
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
        saveButton = findViewById(R.id.button9);
        saveButton.setOnClickListener(view -> {
            String n = name.getText().toString();
            String e = goal1.getText().toString();
            String f = goal2.getText().toString();
            String g = goal3.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(Name, n);
            editor.putString(Goal1, e);
            editor.putString(Goal2, f);
            editor.putString(Goal3, g);
            editor.apply();

        });
        clearButton = findViewById(R.id.button10);
        clearButton.setOnClickListener(view -> {
            name = findViewById(R.id.editTextTextPersonName3);
            goal1 = findViewById(R.id.editTextTextPersonName2);
            goal2 = findViewById(R.id.editTextTextPersonName4);
            goal3 = findViewById(R.id.editTextTextPersonName5);
            name.setText("");
            goal1.setText("");
            goal2.setText("");
            goal3.setText("");
        });
        retrieveButton = findViewById(R.id.button11);
        retrieveButton.setOnClickListener(view -> {
            name = findViewById(R.id.editTextTextPersonName3);
            goal1 = findViewById(R.id.editTextTextPersonName2);
            goal2 = findViewById(R.id.editTextTextPersonName4);
            goal3 = findViewById(R.id.editTextTextPersonName5);
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
        });
        backButton = findViewById(R.id.button12);
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(Profile_Activity.this , MainActivity.class);
            startActivity(intent);
        });
        HoursBtn = findViewById(R.id.button17);
        HoursBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Profile_Activity.this , AddingHours.class);
            startActivity(intent);
        });
        setContentView(R.layout.activity_main);
//Dark Mode//
        btnToggleDark
                = findViewById(R.id.switch1);

        btnToggleDark.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        AppCompatDelegate
                                .setDefaultNightMode(
                                        AppCompatDelegate
                                                .MODE_NIGHT_YES);
                    }
                });
        //Saving to preferences
        setContentView(R.layout.activity_main);
        btnToggleDark
                = findViewById(R.id.switch1);

        // Saving state of our app
        // using SharedPreferences
        SharedPreferences sharedPreferences
                = getSharedPreferences(
                "sharedPrefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor
                = sharedPreferences.edit();
        final boolean isDarkModeOn
                = sharedPreferences
                .getBoolean(
                        "isDarkModeOn", false);

        // When user reopens the app
        // after applying dark/light mode
        if (isDarkModeOn) {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_YES);
            btnToggleDark.setText(
                    "Disable Dark Mode");
        }
        else {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_NO);
            btnToggleDark
                    .setText(
                            "Enable Dark Mode");
        }

        btnToggleDark.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view)
                    {
                        // When user taps the enable/disable
                        // dark mode button
                        if (isDarkModeOn) {

                            // if dark mode is on it
                            // will turn it off
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_NO);
                            // it will set isDarkModeOn
                            // boolean to false
                            editor.putBoolean(
                                    "isDarkModeOn", false);
                            editor.apply();

                            // change text of Button
                            btnToggleDark.setText(
                                    "Enable Dark Mode");
                        }
                        else {

                            // if dark mode is off
                            // it will turn it on
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_YES);

                            // it will set isDarkModeOn
                            // boolean to true
                            editor.putBoolean(
                                    "isDarkModeOn", true);
                            editor.apply();

                            // change text of Button
                            btnToggleDark.setText(
                                    "Disable Dark Mode");
                        }
                    }
                });

    }



}