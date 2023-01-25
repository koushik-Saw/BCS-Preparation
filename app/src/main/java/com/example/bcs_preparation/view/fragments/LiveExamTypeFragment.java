package com.example.bcs_preparation.view.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.adapter.LiveExamTypeAdapter;
import com.example.bcs_preparation.databinding.FragmentLiveExamTypeBinding;
import com.example.bcs_preparation.model.LiveExamTypeModel;
import com.example.bcs_preparation.utils.ConstantUtils;
import com.example.bcs_preparation.utils.InternetConnection;
import com.example.bcs_preparation.viewmodel.LiveExamTypeViewModel;
import com.google.gson.JsonObject;

import java.util.List;


public class LiveExamTypeFragment extends Fragment implements LiveExamTypeAdapter.ItemClickListener{

    private FragmentLiveExamTypeBinding binding;
    private LiveExamTypeViewModel liveExamTypeViewModel;
    private LiveExamTypeAdapter liveExamTypeAdapter;
    private ProgressDialog progressDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLiveExamTypeBinding.inflate(inflater,container,false);
        
        progressDialog = new ProgressDialog(requireActivity());
        
        showProgressDialog();

        liveExamTypeViewModel = new ViewModelProvider(this).get(LiveExamTypeViewModel.class);


        Log.e("checkConnection", "onCreateView: "+InternetConnection.checkConnection(requireActivity()));

        LinearLayoutManager llm = new LinearLayoutManager(requireActivity());
        binding.liveExamTypeFragmentRV.setLayoutManager(llm);

            liveExamTypeViewModel.getByParent().observe(requireActivity(), new Observer<List<LiveExamTypeModel.Datum>>() {
                @Override
                public void onChanged(List<LiveExamTypeModel.Datum> data) {
                    liveExamTypeAdapter = new LiveExamTypeAdapter(requireContext(),data,LiveExamTypeFragment.this::onItemClick);
                    binding.liveExamTypeFragmentRV.setAdapter(liveExamTypeAdapter);

                    progressDialog.dismiss();
                }
            });



        return binding.getRoot();
    }

    private void showProgressDialog() {
        progressDialog.setMessage("Loading...");
        progressDialog.setIcon(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    public void onItemClick(int position) {
        Log.e("hello", "onItemClick: "+ ConstantUtils.LiveExam.LIVE_EXAM_Id);
        Navigation.findNavController(binding.liveExamTypeFragmentRV).navigate(R.id.action_liveExamTypeFragment_to_examTypePreparationFragment);

    }
}