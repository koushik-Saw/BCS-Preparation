package com.example.bcs_preparation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcs_preparation.databinding.ExamTypePreparationRowItemBinding;
import com.example.bcs_preparation.model.ExamTypePreparationModel;
import com.example.bcs_preparation.utils.ConstantUtils;

import java.util.List;

public class ExamTypePreparationAdapter extends RecyclerView.Adapter<ExamTypePreparationAdapter.ExamTypePreparationViewModel>{
    private Context context;
    private List<ExamTypePreparationModel.Datum> examTypeList;
    private ItemClickListener mItemClickListener;

    public ExamTypePreparationAdapter(Context context, List<ExamTypePreparationModel.Datum> examTypeList,
                                      ItemClickListener itemClickListener) {
        this.context = context;
        this.examTypeList = examTypeList;
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ExamTypePreparationViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ExamTypePreparationRowItemBinding binding = ExamTypePreparationRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);
        return new ExamTypePreparationViewModel(binding,mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamTypePreparationViewModel holder, int position) {
        ExamTypePreparationModel.Datum  datum = examTypeList.get(position);
        holder.bind(datum);
    }

    @Override
    public int getItemCount() {
        return examTypeList.size();
    }

    class ExamTypePreparationViewModel extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ExamTypePreparationRowItemBinding binding;
        private ItemClickListener mItemClickListener;
        public ExamTypePreparationViewModel(ExamTypePreparationRowItemBinding itemBinding,ItemClickListener itemClickListener) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
            this.mItemClickListener = itemClickListener;
            binding.liveExamTypeRowItemBtn.setOnClickListener(this);
        }

        public void bind(ExamTypePreparationModel.Datum datum){
            binding.setExamTypePreparation(datum);
        }

        @Override
        public void onClick(View v) {
            ConstantUtils.LiveExam.LIVE_EXAM_ROUTINE = examTypeList.get(getAdapterPosition()).getId();
            mItemClickListener.itemClick(getAdapterPosition(),v);
        }
    }

    public interface ItemClickListener{
        void itemClick(int position,View v);
    }
}
