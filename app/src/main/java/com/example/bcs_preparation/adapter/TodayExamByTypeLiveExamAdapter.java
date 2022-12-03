package com.example.bcs_preparation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcs_preparation.databinding.TodayExamByTypeLiveExamRowItemBinding;
import com.example.bcs_preparation.model.TodayExamByTypeLiveExamRoutineModel;
import com.example.bcs_preparation.utils.ConstantUtils;

import java.util.List;

public class TodayExamByTypeLiveExamAdapter extends RecyclerView.Adapter<TodayExamByTypeLiveExamAdapter.TodayExamByTypeLiveExamViewHolder>{

    private Context mContext;
    private List<TodayExamByTypeLiveExamRoutineModel.Datum> todayExamList;
    private ItemClickListener mItemClickListener;


    public TodayExamByTypeLiveExamAdapter(
            Context context,
            List<TodayExamByTypeLiveExamRoutineModel.Datum> todayExamList,
            ItemClickListener itemClickListener) {
        this.mContext = context;
        this.todayExamList = todayExamList;
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public TodayExamByTypeLiveExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TodayExamByTypeLiveExamRowItemBinding binding = TodayExamByTypeLiveExamRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);
        return new TodayExamByTypeLiveExamViewHolder(binding,mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayExamByTypeLiveExamViewHolder holder, int position) {
        TodayExamByTypeLiveExamRoutineModel.Datum item = todayExamList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return todayExamList.size();
    }

    class TodayExamByTypeLiveExamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TodayExamByTypeLiveExamRowItemBinding mBinding;
        ItemClickListener mItemClickListener;

        public TodayExamByTypeLiveExamViewHolder(
                TodayExamByTypeLiveExamRowItemBinding binding,
                ItemClickListener itemClickListener) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mItemClickListener = itemClickListener;
            binding.syllabusBtnRowItem.setOnClickListener(this);
            binding.giveExamBtnRowItem.setOnClickListener(this);

        }

        public void bind(TodayExamByTypeLiveExamRoutineModel.Datum datum){
            mBinding.setLiveExam(datum);
        }

        @Override
        public void onClick(View v) {
            ConstantUtils.LiveExam.TODAY_LIVE_EXAM_ROUTINE = todayExamList.get(getAdapterPosition()).getId();
            mItemClickListener.giveExamItemClick(getAdapterPosition(),v,v.getId());
        }
    }

    public interface ItemClickListener{
        void giveExamItemClick(int position,View v,int value);
    }
}
