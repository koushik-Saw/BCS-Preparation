package com.example.bcs_preparation.view.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.adapter.TodayExamByTypeArkayevAdapter;
import com.example.bcs_preparation.adapter.TodayExamByTypeLiveExamAdapter;
import com.example.bcs_preparation.databinding.FragmentTodayExamByTypeArkayevBinding;
import com.example.bcs_preparation.model.TodayExamByTypeLiveExamRoutineModel;
import com.example.bcs_preparation.utils.custom_dialog.SyllabusDialog;
import com.example.bcs_preparation.viewmodel.TodayExamByTypeLiveExamRoutineViewModel;

import java.util.List;


public class TodayExamByTypeArkayevFragment extends Fragment implements TodayExamByTypeArkayevAdapter.ItemClickListener{

    private TodayExamByTypeLiveExamRoutineViewModel viewModel;
    private FragmentTodayExamByTypeArkayevBinding binding;
    private TodayExamByTypeArkayevAdapter todayExamByTypeArkayevAdapter;
    private ProgressDialog progressDialog;
    private List<TodayExamByTypeLiveExamRoutineModel.Datum> dataList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentTodayExamByTypeArkayevBinding.inflate(inflater,container,false);

        progressDialog = new ProgressDialog(requireActivity());
        showProgressDialog();

        viewModel = new ViewModelProvider(this).get(TodayExamByTypeLiveExamRoutineViewModel.class);

        LinearLayoutManager llm = new LinearLayoutManager(requireActivity());
        binding.examByTypeArkayvedRV.setLayoutManager(llm);


        viewModel.getPreviousExamByType().observe(requireActivity(), new Observer<List<TodayExamByTypeLiveExamRoutineModel.Datum>>() {
            @Override
            public void onChanged(List<TodayExamByTypeLiveExamRoutineModel.Datum> data) {
                todayExamByTypeArkayevAdapter = new TodayExamByTypeArkayevAdapter(requireActivity(),data,TodayExamByTypeArkayevFragment.this);
                binding.examByTypeArkayvedRV.setAdapter(todayExamByTypeArkayevAdapter);
                todayExamByTypeArkayevAdapter.notifyDataSetChanged();
                dataList = data;
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
    public void onClick(View v, int position) {
        switch (v.getId()){
            case R.id.give_exam_btn_row_item:
                Toast.makeText(getActivity(), "give_exam_btn_row_item_1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.talent_list_btn_row_item:
                Toast.makeText(getActivity(), "talent_list_btn_row_item_1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.question_btn_row_item:
                Toast.makeText(getActivity(), "question_btn_row_item_1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.syllabus_btn_row_item:
                SyllabusDialog dialog = new SyllabusDialog("সিলেবাস",dataList.get(position).getSyllabus());
                dialog.setCancelable(false);
                dialog.show(getChildFragmentManager(),"SyllabusDialog");
                break;
        }

    }
}