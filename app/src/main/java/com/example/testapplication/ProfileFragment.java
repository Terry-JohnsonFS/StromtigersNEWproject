package com.example.testapplication;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapplication.ui.home.HomeFragment;

import java.util.Collections;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    String name, goal1, goal2, goal3;
    EditText textPersonName;
    EditText textGoal1;
    EditText textGoal2;
    EditText textGoal3;
    Button backButton;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Goal1 = "Goal1";
    public static final String Goal2 = "Goal2";
    public static final String Goal3 = "Goal3";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(name , String.valueOf(textPersonName));
        editor.apply();

        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("Name", "");*/
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet(name, Collections.singleton(String.valueOf(R.id.editTextTextPersonName3)));
        editor.apply();



        return inflater.inflate(R.layout.fragment_profile, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        // TODO: Use the ViewModel
    }


   /* public EditText getTextGoal1() {
        return textGoal1;
    }

    public EditText getTextGoal2() {
        return textGoal2;
    }

    public EditText getTextGoal3() {
        return textGoal3;
    }

    public EditText getTextPersonName() {
        return textPersonName;
    }*/
}