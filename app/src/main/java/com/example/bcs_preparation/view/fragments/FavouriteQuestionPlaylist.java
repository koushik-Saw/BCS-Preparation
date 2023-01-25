package com.example.bcs_preparation.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.adapter.FavouriteQuestionPlaylistAdapter;
import com.example.bcs_preparation.databinding.FragmentFavouriteQuestionPlaylistBinding;
import com.example.bcs_preparation.viewmodel.FavouriteQuestionPlaylistViewModel;

import java.util.List;

public class FavouriteQuestionPlaylist extends DialogFragment {

    FavouriteQuestionPlaylistAdapter favouriteQuestionPlaylistAdapter;
    private FavouriteQuestionPlaylistViewModel viewModel;
    private FragmentFavouriteQuestionPlaylistBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavouriteQuestionPlaylistBinding.inflate(inflater,container,false);
        viewModel = new ViewModelProvider(requireActivity()).get(FavouriteQuestionPlaylistViewModel.class);

        viewModel.getFavoriteQuestionPlayListName().observe(requireActivity(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> playList) {
                for(int i=0;i<playList.size();i++){
                    Log.e("playListName", "onChanged: "+playList.get(i) );
                }
                favouriteQuestionPlaylistAdapter = new FavouriteQuestionPlaylistAdapter(FavouriteQuestionPlaylist.this::ocClick);
                binding.FavQuesPlaylistRecVID.setAdapter(favouriteQuestionPlaylistAdapter);
            }
        });


        return binding.getRoot();
    }

    private void ocClick(int i, View view) {
        Toast.makeText(getContext(), "Playlsit", Toast.LENGTH_SHORT).show();
    }
}