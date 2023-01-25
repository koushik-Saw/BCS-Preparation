package com.example.bcs_preparation.view.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.bcs_preparation.adapter.RankListAdapter;
import com.example.bcs_preparation.databinding.FragmentRankListBinding;
import com.example.bcs_preparation.model.RankListModel;
import com.example.bcs_preparation.viewmodel.RankListViewModel;

import java.util.List;


public class RankListFragment extends Fragment {

    private FragmentRankListBinding binding;
    private RankListViewModel viewModel;
    private ProgressDialog progressDialog;
    private List<RankListModel.Datum> datumList;
    private RankListAdapter rankListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentRankListBinding.inflate(inflater,container,false);

        viewModel = new ViewModelProvider(this).get(RankListViewModel.class);

        binding.rankListRV.setLayoutManager(new LinearLayoutManager(requireActivity()));

        progressDialog = new ProgressDialog(requireActivity());
        showProgressDialog();

        viewModel.getRankList().observe(requireActivity(), new Observer<List<RankListModel.Datum>>() {
            @Override
            public void onChanged(List<RankListModel.Datum> data) {
                rankListAdapter = new RankListAdapter(requireActivity(),data);
                datumList = data;
                rankListAdapter.notifyDataSetChanged();
                binding.rankListRV.setAdapter(rankListAdapter);
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
}