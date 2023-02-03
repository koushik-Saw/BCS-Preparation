package com.example.bcs_preparation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.databinding.FavouriteQuestionPlaylistBinding;
import com.example.bcs_preparation.model.FavouriteQuestionPlaylistModel;

import java.util.List;

public class FavouriteQuestionPlaylistAdapter extends RecyclerView.Adapter<FavouriteQuestionPlaylistAdapter.FavouriteQuestionPlaylsitViewholder> {

    private Context context;
    private List<FavouriteQuestionPlaylistModel.Datum> playList;

    public FavouriteQuestionPlaylistAdapter(Context context, List<FavouriteQuestionPlaylistModel.Datum> playList) {
        this.context = context;
        this.playList = playList;
    }


    @NonNull
    @Override
    public FavouriteQuestionPlaylsitViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FavouriteQuestionPlaylistBinding binding = FavouriteQuestionPlaylistBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false
        );
        return new FavouriteQuestionPlaylsitViewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteQuestionPlaylsitViewholder holder, int position) {
        FavouriteQuestionPlaylistModel.Datum list = playList.get(position);
        holder.bind(list);
    }

    @Override
    public int getItemCount() {
        return playList.size();
    }

    class FavouriteQuestionPlaylsitViewholder extends RecyclerView.ViewHolder {

        private FavouriteQuestionPlaylistBinding mBinding;

        public FavouriteQuestionPlaylsitViewholder(FavouriteQuestionPlaylistBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

        public void bind(FavouriteQuestionPlaylistModel.Datum playList){
            mBinding.setPlayList(playList);
        }
    }
}
