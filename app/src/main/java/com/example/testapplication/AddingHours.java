package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddingHours extends AppCompatActivity {
    Button BtnSave;
    Button BtnRet;
    Button BtnBack;
    SharedPreferences sharedPreferences1;
    TextView textView;
    TextView textView3;
    TextView textView4;
    TextView hoursG1;
    TextView hoursG2;
    TextView hoursG3;

    public static final String mypreference1 = "mypref";
    public static final String Goal1 = "Goal1Key";
    public static final String Goal2 = "Goal2Key";
    public static final String Goal3 = "Goal3Key";
    public static final String HoursG1 = "HoursGoal1Key";
    public static final String HoursG2 = "HoursGoal2Key";
    public static final String HoursG3 = "HoursGoal3Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_hours);

        hoursG1 = (TextView) findViewById(R.id.editTextTextPersonName6);
        hoursG2 = (TextView) findViewById(R.id.editTextTextPersonName7);
        hoursG3 = (TextView) findViewById(R.id.editTextTextPersonName8);
        sharedPreferences1 = getSharedPreferences(mypreference1,
                Context.MODE_PRIVATE);
        if (sharedPreferences1.contains(HoursG1)) {
            hoursG1.setText(sharedPreferences1.getString(HoursG1, ""));
        }
        if (sharedPreferences1.contains(HoursG2)) {
            hoursG2.setText(sharedPreferences1.getString(HoursG2, ""));
        }
        if (sharedPreferences1.contains(HoursG3)) {
            hoursG3.setText(sharedPreferences1.getString(HoursG3, ""));
        }
        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        sharedPreferences1 = getSharedPreferences(mypreference1 , Context.MODE_PRIVATE);
        String goal1 = sharedPreferences1.getString(Goal1, "");
        String goal2 = sharedPreferences1.getString(Goal2, "");
        String goal3 = sharedPreferences1.getString(Goal3, "");

        textView.setText(goal1);
        textView3.setText(goal2);
        textView4.setText(goal3);

        BtnSave = (Button) findViewById(R.id.button13);
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String HG1 = hoursG1.getText().toString();
                String HG2 = hoursG2.getText().toString();
                String HG3 = hoursG3.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putString(HoursG1, HG1);
                editor.putString(HoursG2, HG2);
                editor.putString(HoursG3, HG3);
                editor.commit();
            }
        });
        BtnRet = (Button)  findViewById(R.id.button14);
        BtnRet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoursG1 = (TextView) findViewById(R.id.editTextTextPersonName6);
                hoursG2 = (TextView) findViewById(R.id.editTextTextPersonName7);
                hoursG3 = (TextView) findViewById(R.id.editTextTextPersonName8);
                sharedPreferences1 = getSharedPreferences(mypreference1, Context.MODE_PRIVATE);
                if (sharedPreferences1.contains(HoursG1)) {
                    hoursG1.setText(sharedPreferences1.getString(HoursG1, ""));
                }
                if (sharedPreferences1.contains(HoursG2)) {
                    hoursG2.setText(sharedPreferences1.getString(HoursG2, ""));
                }
                if (sharedPreferences1.contains(HoursG3)) {
                    hoursG3.setText(sharedPreferences1.getString(HoursG3, ""));
                }
            }
        });
        BtnBack = (Button) findViewById(R.id.button15);
        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddingHours.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}