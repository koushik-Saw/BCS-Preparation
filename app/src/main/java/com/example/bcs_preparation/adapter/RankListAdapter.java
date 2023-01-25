package com.example.bcs_preparation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.databinding.RankListRowItemBinding;
import com.example.bcs_preparation.model.RankListModel;

import java.util.List;

public class RankListAdapter extends RecyclerView.Adapter<RankListAdapter.RankListViewHolder> {
    private Context context;
    private List<RankListModel.Datum> dataList;

    public RankListAdapter(Context context, List<RankListModel.Datum> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RankListRowItemBinding  binding = RankListRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);
        return new RankListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RankListViewHolder holder, int position) {
        RankListModel.Datum datum = dataList.get(position);
        holder.mBinding.rankListRowItemTotalQuestionCountTV.setText(""+(position+1));
        holder.bind(datum);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class RankListViewHolder extends RecyclerView.ViewHolder{
        private RankListRowItemBinding mBinding;

        public RankListViewHolder(RankListRowItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bind(RankListModel.Datum datum){
            mBinding.setRank(datum);
        }
    }
}
