package com.example.testapplication.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testapplication.MainActivity;
import com.example.testapplication.R;
import com.example.testapplication.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    ProgressBar progressBar1;
    Button btn5;
    ProgressBar progressBar2;
    Button btn6;
    ProgressBar progressBar3;
    Button btn7;
    Button BtnBAck;
    TextView goal1DF;
    TextView goal2DF;
    TextView goal3DF;
    int progbar1;
    int progbar2;
    int progbar3;

    SharedPreferences sharedPreferences2;
    public static final String mypreference2 = "mypref";
    public static final String HoursG1 = "HoursGoal1Key";
    public static final String HoursG2 = "HoursGoal2Key";
    public static final String HoursG3 = "HoursGoal3Key";
    public static final String Goal1 = "Goal1Key";
    public static final String Goal2 = "Goal2Key";
    public static final String Goal3 = "Goal3Key";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.editTextTextPersonName;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        goal1DF = (TextView) root.findViewById(R.id.textView6);
        goal2DF = (TextView) root.findViewById(R.id.textView7);
        goal3DF = (TextView) root.findViewById(R.id.textView8);

        sharedPreferences2 = getContext().getSharedPreferences(mypreference2, Context.MODE_PRIVATE);
        String goal1 = sharedPreferences2.getString(Goal1,"");
        String goal2 = sharedPreferences2.getString(Goal2, "");
        String goal3 = sharedPreferences2.getString(Goal3, "");
        goal1DF.setText(goal1);
        goal2DF.setText(goal2);
        goal3DF.setText(goal3);

        String sprogressbar1 = sharedPreferences2.getString(HoursG1, "");
        String sprogressbar2 = sharedPreferences2.getString(HoursG2, "");
        String sprogressbar3 = sharedPreferences2.getString(HoursG3, "");
        progbar1 = Integer.parseInt(sprogressbar1);
        progbar2 = Integer.parseInt(sprogressbar2);
        progbar3 = Integer.parseInt(sprogressbar3);


        progressBar1 = (ProgressBar) root.findViewById(R.id.progressBar3);
        if (progbar1 >= 1){
            progressBar1.setMax(progbar1);
        }
        else{
            progressBar1.setMax(30);
        }
        progressBar1.setProgress(0);
        btn5 = (Button) root.findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int progress = progressBar1.getProgress();
                progress = progress +1;
                progressBar1.setProgress(progress);


            }
        });
        progressBar2 = (ProgressBar) root.findViewById(R.id.progressBar4);
        if (progbar2 >= 1){
            progressBar2.setMax(progbar2);
        }
        else{
            progressBar2.setMax(30);
        }
        progressBar2.setProgress(0);
        btn6 = (Button) root.findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int progress = progressBar2.getProgress();
                progress = progress +1;
                progressBar2.setProgress(progress);

            }
        });
        progressBar3 = (ProgressBar) root.findViewById(R.id.progressBar5);
        if (progbar3 >= 1){
            progressBar3.setMax(progbar3);
        }
        else{
            progressBar3.setMax(30);
        }
        progressBar3.setProgress(0);
        btn7 = (Button) root.findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int progress = progressBar3.getProgress();
                progress = progress +1;
                progressBar3.setProgress(progress);

            }
        });
        BtnBAck = (Button) root.findViewById(R.id.button);
        BtnBAck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void IncrementBar3(View view){

        int progress = progressBar1.getProgress();
        progressBar1.setProgress(progress++);
    }
    public void IncrementBar4(View view) {
        int progress = progressBar2.getProgress();
        progressBar2.setProgress(progress++);

    }
    public void IncrementBar5(View view) {
        int progress = progressBar3.getProgress();
        progressBar3.setProgress(progress++);

    }


}