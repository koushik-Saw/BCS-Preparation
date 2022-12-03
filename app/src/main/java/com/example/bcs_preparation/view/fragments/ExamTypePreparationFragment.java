package com.example.bcs_preparation.view.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.adapter.ExamTypePreparationAdapter;
import com.example.bcs_preparation.databinding.FragmentExamTypePreparationBinding;
import com.example.bcs_preparation.model.ExamTypePreparationModel;
import com.example.bcs_preparation.utils.InternetConnection;
import com.example.bcs_preparation.viewmodel.ExamTypePreparationViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.List;


public class ExamTypePreparationFragment extends Fragment implements ExamTypePreparationAdapter.ItemClickListener{

    private FragmentExamTypePreparationBinding binding;
    private ExamTypePreparationViewModel examTypePreparationViewModel;
    private ExamTypePreparationAdapter examTypePreparationAdapter;
    private  ProgressDialog progressDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentExamTypePreparationBinding.inflate(inflater,container,false);
        examTypePreparationViewModel = new ViewModelProvider(this).get(ExamTypePreparationViewModel.class);

        progressDialog = new ProgressDialog(requireActivity());
        showProgressDialog();

        LinearLayoutManager llm = new LinearLayoutManager(requireActivity());
        binding.examTypePreparationFragmentRV.setLayoutManager(llm);

        if(InternetConnection.checkConnection(requireContext())){
            examTypePreparationViewModel.getExamTypePreparationData().observe(requireActivity(), new Observer<List<ExamTypePreparationModel.Datum>>() {
                @Override
                public void onChanged(List<ExamTypePreparationModel.Datum> data) {
                    examTypePreparationAdapter = new ExamTypePreparationAdapter(requireContext(),data,ExamTypePreparationFragment.this);
                    binding.examTypePreparationFragmentRV.setAdapter(examTypePreparationAdapter);
                    progressDialog.dismiss();

                }
            });
        }
        return binding.getRoot();
    }

    private void showProgressDialog() {
        progressDialog.setMessage("Loading...");
        progressDialog.setIcon(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }


    @Override
    public void itemClick(int position,View v) {
        Navigation.findNavController(v).navigate(R.id.action_examTypePreparationFragment_to_todayExamByTypeFragment);
    }
}