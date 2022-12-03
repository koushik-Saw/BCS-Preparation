package com.example.bcs_preparation.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bcs_preparation.adapter.TodayExamByTypeFragmentAdapter;
import com.example.bcs_preparation.databinding.FragmentTodayExamByTypeBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TodayExamByTypeFragment extends Fragment {

    private FragmentTodayExamByTypeBinding binding;
    private TodayExamByTypeFragmentAdapter adapter;
    private TabLayoutMediator tabLayoutMediator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentTodayExamByTypeBinding.inflate(inflater,container,false);

        adapter = new TodayExamByTypeFragmentAdapter(requireActivity());
        binding.todayExamByTypeViewPager.setAdapter(adapter);

        tabLayoutMediator = new TabLayoutMediator(
                binding.todayExamByTypeTabLayout,
                binding.todayExamByTypeViewPager,
                true,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0: tab.setText("লাইভ পরীক্ষার রুটিন");
                            break;
                            case 1: tab.setText("আর্কাইভ");
                            break;
                        }
                    }
                });

        tabLayoutMediator.attach();

        return binding.getRoot();
    }
}