package com.example.bcs_preparation;

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

import com.example.bcs_preparation.adapter.FavouritePlaylistNameAdapter;
import com.example.bcs_preparation.databinding.FragmentFavouritePlaylistNameBinding;
import com.example.bcs_preparation.databinding.FragmentFavouriteQuestionPlaylistBinding;
import com.example.bcs_preparation.model.FavouriteQuestionPlaylistModel;
import com.example.bcs_preparation.viewmodel.FavouriteQuestionPlaylistViewModel;

import java.util.List;


public class FavouritePlaylistNameFragment extends Fragment {

    private FragmentFavouritePlaylistNameBinding binding;
    private FavouritePlaylistNameAdapter playListNameAdapter;
    private FavouriteQuestionPlaylistViewModel viewModel;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentFavouritePlaylistNameBinding.inflate(inflater,container,false);

        progressDialog = new ProgressDialog(requireActivity());
        showProgressDialog();

        viewModel = new ViewModelProvider(this).get(FavouriteQuestionPlaylistViewModel.class);

        binding.favouritePlaylistNameRV.setLayoutManager(new LinearLayoutManager(requireContext()));


        viewModel.getFavoriteQuestionPlayListName().observe(requireActivity(), new Observer<List<FavouriteQuestionPlaylistModel.Datum>>() {
            @Override
            public void onChanged(List<FavouriteQuestionPlaylistModel.Datum> playList) {
                progressDialog.dismiss();
                playListNameAdapter = new FavouritePlaylistNameAdapter(requireContext(),playList);
                binding.favouritePlaylistNameRV.setAdapter(playListNameAdapter);
                Log.e("playList", "onChanged: "+playList.get(0) );

            }
        });
        return binding.getRoot();
    }

    private void showProgressDialog() {
        progressDialog.setMessage("Loading....");
        progressDialog.setIcon(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
}