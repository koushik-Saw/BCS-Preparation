package com.example.bcs_preparation.view.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.adapter.TodayExamByTypeLiveExamAdapter;
import com.example.bcs_preparation.databinding.FragmentTodayExamByTypeLiveExamBinding;
import com.example.bcs_preparation.model.TodayExamByTypeLiveExamRoutineModel;
import com.example.bcs_preparation.utils.custom_dialog.SyllabusDialog;
import com.example.bcs_preparation.viewmodel.TodayExamByTypeLiveExamRoutineViewModel;

import java.util.List;


public class TodayExamByTypeLiveExamFragment extends Fragment implements TodayExamByTypeLiveExamAdapter.ItemClickListener{

    private FragmentTodayExamByTypeLiveExamBinding binding;
    private TodayExamByTypeLiveExamRoutineViewModel viewModel;
    private TodayExamByTypeLiveExamAdapter todayExamByTypeLiveExamAdapter;
    private  ProgressDialog progressDialog;
    private List<TodayExamByTypeLiveExamRoutineModel.Datum> dataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTodayExamByTypeLiveExamBinding.inflate(inflater,container,false);

        viewModel = new ViewModelProvider(this).get(TodayExamByTypeLiveExamRoutineViewModel.class);

        progressDialog = new ProgressDialog(requireActivity());
        showProgressDialog();

        LinearLayoutManager llm = new LinearLayoutManager(requireActivity());
        binding.todayExamByTypeLiveExamRV.setLayoutManager(llm);


        viewModel.getTodayExamByTypeLiveExamRoutineModel().observe(requireActivity(), new Observer<List<TodayExamByTypeLiveExamRoutineModel.Datum>>() {
            @Override
            public void onChanged(List<TodayExamByTypeLiveExamRoutineModel.Datum> data) {
                todayExamByTypeLiveExamAdapter = new TodayExamByTypeLiveExamAdapter(requireActivity(),data,TodayExamByTypeLiveExamFragment.this);
                binding.todayExamByTypeLiveExamRV.setAdapter(todayExamByTypeLiveExamAdapter);
                dataList = data;
                todayExamByTypeLiveExamAdapter.notifyDataSetChanged();
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
    public void giveExamItemClick(int position, View v,int value) {
        switch (v.getId()){
            case R.id.give_exam_btn_row_item:
                Toast.makeText(getActivity(), "give_exam_btn_row_item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.syllabus_btn_row_item:
                SyllabusDialog dialog = new SyllabusDialog("সিলেবাস",dataList.get(position).getSyllabus());
                dialog.show(getChildFragmentManager(),"SyllabusDialog");
                break;
        }
    }



}