package com.example.bcs_preparation.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcs_preparation.databinding.ExamQuestionRowItemBinding;
import com.example.bcs_preparation.model.ExamQuestionModel;
import com.example.bcs_preparation.utils.custom_dialog.SyllabusDialog;
import com.example.bcs_preparation.view.fragments.ExamQuestionFragment;

import java.util.ArrayList;
import java.util.List;

public class ExamQuestionAdapter extends RecyclerView.Adapter<ExamQuestionAdapter.ExamQuestionViewHolder> {
    private Context mContext;
    private List<ExamQuestionModel.Question__1> questionList;
    private ExamQuestionAdapter.ItemClickListener mItemClickListener;

    public ExamQuestionAdapter(Context context, List<ExamQuestionModel.Question__1> questionList, ItemClickListener itemClickListener) {
        this.mContext = context;
        this.questionList = questionList;
        this.mItemClickListener = itemClickListener;

    }

    @NonNull
    @Override
    public ExamQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ExamQuestionRowItemBinding binding = ExamQuestionRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);

        return new ExamQuestionViewHolder(binding,mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamQuestionViewHolder holder, int position) {

        ExamQuestionModel.Question__1 datum = questionList.get(position);
        holder.bind(datum);

        if(datum.getCorrectAnswer() == 1){
            holder.mBinding.nestedExamQuestionOp1IVRowItemID.setVisibility(View.VISIBLE);
        }else if(datum.getCorrectAnswer() == 2){
            holder.mBinding.nestedExamQuestionOp2IVRowItemID.setVisibility(View.VISIBLE);
        }else if(datum.getCorrectAnswer() == 3){
            holder.mBinding.nestedExamQuestionOp3IVRowItemID.setVisibility(View.VISIBLE);
        }else if(datum.getCorrectAnswer() == 4){
            holder.mBinding.nestedExamQuestionOp4IVRowItemID.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    class ExamQuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ExamQuestionRowItemBinding mBinding;
        private ExamQuestionAdapter.ItemClickListener mItemClickListener;

        public ExamQuestionViewHolder(ExamQuestionRowItemBinding binding,
                                      ExamQuestionAdapter.ItemClickListener itemClickListener) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mItemClickListener = itemClickListener;


            binding.nestedExamQuestionExplanationBTNRowItem.setOnClickListener(this);
            binding.examOptionIVRowItemID.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View w) {
                    mItemClickListener.onClick(w,getAdapterPosition(),1);
                }
            });

        }

        public void bind(ExamQuestionModel.Question__1 question){
            mBinding.setOption(question);
        }

        @Override
        public void onClick(View v) {

            mItemClickListener.onClick(v,getAdapterPosition(),0);

        }

    }

    public interface ItemClickListener{
        void onClick(View v,int position,int value);
    }
}
