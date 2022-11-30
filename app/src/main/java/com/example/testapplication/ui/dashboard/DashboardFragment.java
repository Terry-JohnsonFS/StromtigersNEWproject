package com.example.testapplication.ui.dashboard;

import android.content.Intent;
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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.editTextTextPersonName;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        progressBar1 = (ProgressBar) root.findViewById(R.id.progressBar3);
        progressBar1.setMax(30);
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
        progressBar2.setMax(30);
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
        progressBar3.setMax(30);
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