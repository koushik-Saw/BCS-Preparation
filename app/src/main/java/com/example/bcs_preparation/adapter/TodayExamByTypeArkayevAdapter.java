package com.example.bcs_preparation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcs_preparation.databinding.TodayExamByTypeArkyvedRowItemBinding;
import com.example.bcs_preparation.model.TodayExamByTypeLiveExamRoutineModel;
import com.example.bcs_preparation.utils.ConstantUtils;

import java.util.List;

public class TodayExamByTypeArkayevAdapter extends RecyclerView.Adapter<TodayExamByTypeArkayevAdapter.TodayExamByTypeArkayevViewHolder>{

    private Context mContext;
    private List<TodayExamByTypeLiveExamRoutineModel.Datum> todayExamList;
    private TodayExamByTypeArkayevAdapter.ItemClickListener mItemClickListener;


    public TodayExamByTypeArkayevAdapter(
            Context mContext,
            List<TodayExamByTypeLiveExamRoutineModel.Datum> todayExamList,
            TodayExamByTypeArkayevAdapter.ItemClickListener itemClickListener) {
        this.mContext = mContext;
        this.todayExamList = todayExamList;
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public TodayExamByTypeArkayevViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TodayExamByTypeArkyvedRowItemBinding binding = TodayExamByTypeArkyvedRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);
        return new TodayExamByTypeArkayevViewHolder(binding,mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayExamByTypeArkayevViewHolder holder, int position) {
        TodayExamByTypeLiveExamRoutineModel.Datum item = todayExamList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return todayExamList.size();
    }

    class TodayExamByTypeArkayevViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TodayExamByTypeArkyvedRowItemBinding mBinding;
        TodayExamByTypeArkayevAdapter.ItemClickListener mItemClickListener;

        public TodayExamByTypeArkayevViewHolder(
                TodayExamByTypeArkyvedRowItemBinding binding,
                TodayExamByTypeArkayevAdapter.ItemClickListener itemClickListener) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mItemClickListener = itemClickListener;
            binding.giveExamBtnRowItem.setOnClickListener(this);
            binding.talentListBtnRowItem.setOnClickListener(this);
            binding.questionBtnRowItem.setOnClickListener(this);
            binding.syllabusBtnRowItem.setOnClickListener(this);
        }

        public void bind(TodayExamByTypeLiveExamRoutineModel.Datum datum){
            mBinding.setLiveExam(datum);
        }


        @Override
        public void onClick(View v) {
            ConstantUtils.LiveExam.PREVIOUS_EXAM_ARKAYVED = todayExamList.get(getAdapterPosition()).getId();
            mItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public interface ItemClickListener{
        void onClick(View v,int position);
    }
}
