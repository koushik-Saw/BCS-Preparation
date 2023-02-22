package com.example.bcs_preparation.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.databinding.FragmentCreatePlaylistBinding;
import com.example.bcs_preparation.viewmodel.UserFavoriteQuestionCreateViewModel;


public class CreatePlaylistFragment extends DialogFragment {

    private UserFavoriteQuestionCreateViewModel viewModel;
    private FragmentCreatePlaylistBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCreatePlaylistBinding.inflate(inflater,container,false);
        viewModel = new ViewModelProvider(this).get(UserFavoriteQuestionCreateViewModel.class);



        binding.createPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.playlistname.getText().toString();
                viewModel.createFavoriteQuestion(name).observe(requireActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Log.e("detailsSuccess", "onChanged: "+s );
                    }
                });
            }
        });

        return binding.getRoot();
    }
}