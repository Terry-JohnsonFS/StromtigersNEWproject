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
    TextView displayprog1DF;
    TextView displayprog2DF;
    TextView displayprog3DF;
    int progbar1;
    int progbar2;
    int progbar3;
    String Click2Start = "Track with +";

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
        goal1DF = root.findViewById(R.id.textView6);
        goal2DF = root.findViewById(R.id.textView7);
        goal3DF = root.findViewById(R.id.textView8);

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

        displayprog1DF = root.findViewById(R.id.textView9);
        displayprog2DF = root.findViewById(R.id.textView10);
        displayprog3DF = root.findViewById(R.id.textView11);


        progressBar1 = root.findViewById(R.id.progressBar3);
        if (progbar1 >= 1){
            progressBar1.setMax(progbar1);
        }
        else{
            progressBar1.setMax(30);
        }
        progressBar1.setProgress(0);
        displayprog1DF.setText(Click2Start);
        btn5 = root.findViewById(R.id.button5);
        btn5.setOnClickListener(view -> {
            int progress = progressBar1.getProgress();
            progress = progress +1;
            progressBar1.setProgress(progress);
            if(progress<=progbar1){
                displayprog1DF.setText(progress + "/" + progbar1);
            }
        });
        progressBar2 = root.findViewById(R.id.progressBar4);
        if (progbar2 >= 1){
            progressBar2.setMax(progbar2);
        }
        else{
            progressBar2.setMax(30);
        }
        progressBar2.setProgress(0);
        displayprog2DF.setText(Click2Start);
        btn6 = root.findViewById(R.id.button6);
        btn6.setOnClickListener(view -> {
            int progress = progressBar2.getProgress();
            progress = progress +1;
            progressBar2.setProgress(progress);
            if(progress <= progbar2){
                displayprog2DF.setText(progress + "/" + progbar2);
            }
        });
        progressBar3 = root.findViewById(R.id.progressBar5);
        if (progbar3 >= 1){
            progressBar3.setMax(progbar3);
        }
        else{
            progressBar3.setMax(30);
        }
        progressBar3.setProgress(0);
        displayprog3DF.setText(Click2Start);
        btn7 = root.findViewById(R.id.button7);
        btn7.setOnClickListener(view -> {
            int progress = progressBar3.getProgress();
            progress = progress +1;
            progressBar3.setProgress(progress);
            if(progress <= progbar3){
                displayprog3DF.setText(progress + "/" + progbar3);
            }
        });
        BtnBAck = root.findViewById(R.id.button);
        BtnBAck.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}