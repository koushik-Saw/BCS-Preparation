package com.example.bcs_preparation.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.adapter.FavouriteQuestionPlaylistAdapter;
import com.example.bcs_preparation.databinding.FragmentFavouriteQuestionPlaylistBinding;
import com.example.bcs_preparation.model.FavouriteQuestionPlaylistModel;
import com.example.bcs_preparation.viewmodel.FavouriteQuestionPlaylistViewModel;

import java.util.List;

public class FavouriteQuestionPlaylist extends DialogFragment{

    FavouriteQuestionPlaylistAdapter favouriteQuestionPlaylistAdapter;
    private FavouriteQuestionPlaylistViewModel viewModel;
    private FragmentFavouriteQuestionPlaylistBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavouriteQuestionPlaylistBinding.inflate(inflater,container,false);

        viewModel = new ViewModelProvider(requireActivity()).get(FavouriteQuestionPlaylistViewModel.class);

        binding.FavQuesPlaylistRecVID.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.CreatePlaylistID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatePlaylistFragment createPlaylistFragment = new CreatePlaylistFragment();
                createPlaylistFragment.show(getParentFragmentManager(),"");
            }
        });

        viewModel.getFavoriteQuestionPlayListName().observe(requireActivity(), new Observer<List<FavouriteQuestionPlaylistModel.Datum>>() {
            @Override
            public void onChanged(List<FavouriteQuestionPlaylistModel.Datum> data) {
                favouriteQuestionPlaylistAdapter = new FavouriteQuestionPlaylistAdapter(requireContext(),data);
                binding.FavQuesPlaylistRecVID.setAdapter(favouriteQuestionPlaylistAdapter);
            }
        });


        return binding.getRoot();
    }
}