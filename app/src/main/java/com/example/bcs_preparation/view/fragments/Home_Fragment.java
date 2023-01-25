package com.example.bcs_preparation.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.databinding.FragmentHomeBinding;
import com.example.bcs_preparation.preferences.AuthenticationPref;
import com.example.bcs_preparation.utils.ConstantUtils;

public class Home_Fragment extends Fragment {

    private FragmentHomeBinding binding;
    private AuthenticationPref authPref;

    public Home_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        authPref = new AuthenticationPref(requireContext());

        ConstantUtils.LiveExam.LOGIN_USER_Id = authPref.getUserID();

        binding.homeFragmentLiveExamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_home_Fragment_to_liveExamTypeFragment);
            }
        });
        binding.homeFragmentFavoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_home_Fragment_to_favouritePlaylistNameFragment);
            }
        });

        return binding.getRoot();
    }
}