package com.example.bcs_preparation.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bcs_preparation.view.fragments.TodayExamByTypeArkayevFragment;
import com.example.bcs_preparation.view.fragments.TodayExamByTypeLiveExamFragment;

public class TodayExamByTypeFragmentAdapter extends FragmentStateAdapter {

    public TodayExamByTypeFragmentAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
         switch(position){
             case 0: return new TodayExamByTypeLiveExamFragment();
             case 1: return new TodayExamByTypeArkayevFragment();
             default: return null;
         }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
