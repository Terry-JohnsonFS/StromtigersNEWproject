package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.testapplication.ui.home.HomeFragment;

public class Profile_Activity extends AppCompatActivity {
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
        setContentView(R.layout.activity_profile);
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
        backButton = (Button) findViewById(R.id.button12);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile_Activity.this , MainActivity.class);
                startActivity(intent);
            }
        });

    }



}