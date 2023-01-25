package com.example.bcs_preparation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcs_preparation.databinding.FavouriteQuestionPlaylistBinding;
import com.example.bcs_preparation.model.FavouriteQuestionPlaylistModel;
import com.example.bcs_preparation.view.fragments.FavouriteQuestionPlaylist;

import java.util.List;

public class FavouritePlaylistNameAdapter extends RecyclerView.Adapter<FavouritePlaylistNameAdapter.FavouritePlaylistNameViewHolder> {
    private Context context;
    private List<FavouriteQuestionPlaylistModel.Datum> playList;

    public FavouritePlaylistNameAdapter(Context context, List<FavouriteQuestionPlaylistModel.Datum> playList) {
        this.context = context;
        this.playList = playList;
    }

    @NonNull
    @Override
    public FavouritePlaylistNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FavouriteQuestionPlaylistBinding binding = FavouriteQuestionPlaylistBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false
        );
        return new FavouritePlaylistNameViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritePlaylistNameViewHolder holder, int position) {
        FavouriteQuestionPlaylistModel.Datum list = playList.get(position);
        holder.bind(list);
    }

    @Override
    public int getItemCount() {
        return playList.size();
    }

    class FavouritePlaylistNameViewHolder extends RecyclerView.ViewHolder {
        private FavouriteQuestionPlaylistBinding mBinding;

        public FavouritePlaylistNameViewHolder(FavouriteQuestionPlaylistBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

        public void bind(FavouriteQuestionPlaylistModel.Datum playList){
            mBinding.setPlayList(playList);
        }
    }
}
