package com.example.bcs_preparation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.databinding.FragmentLiveExamTypeBinding;
import com.example.bcs_preparation.databinding.LiveExamTypeRowItemBinding;
import com.example.bcs_preparation.model.LiveExamTypeModel;
import com.example.bcs_preparation.utils.ConstantUtils;

import java.util.List;

public class LiveExamTypeAdapter extends RecyclerView.Adapter<LiveExamTypeAdapter.LiveExamTypeViewModel>{

    private Context context;
    private List<LiveExamTypeModel.Datum> mExamTypeList;
    private ItemClickListener mItemClickListener;

    public LiveExamTypeAdapter(Context context, List<LiveExamTypeModel.Datum> examTypeList,ItemClickListener itemClickListener) {
        this.context = context;
        this.mExamTypeList = examTypeList;
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public LiveExamTypeViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LiveExamTypeRowItemBinding binding =  LiveExamTypeRowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);
        return new LiveExamTypeViewModel(binding,mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveExamTypeViewModel holder, int position) {
        LiveExamTypeModel.Datum datum = mExamTypeList.get(position);
        holder.bind(datum);

    }

    @Override
    public int getItemCount() {
        return mExamTypeList.size();
    }

    class LiveExamTypeViewModel  extends RecyclerView.ViewHolder implements View.OnClickListener{
        private LiveExamTypeRowItemBinding binding;
        private ItemClickListener itemClickListener;
        public LiveExamTypeViewModel(LiveExamTypeRowItemBinding itemBinding,ItemClickListener itemClickListener) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
            this.itemClickListener = itemClickListener;
            binding.liveExamTypeRowItemBtn.setOnClickListener(this);
        }

        public void bind(LiveExamTypeModel.Datum datum){
            binding.setLiveExamDataType(datum);
        }

        @Override
        public void onClick(View v) {
            ConstantUtils.LiveExam.LIVE_EXAM_Id = mExamTypeList.get(getAdapterPosition()).getId();
            itemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface ItemClickListener{
         void onItemClick(int position);
    }


}
