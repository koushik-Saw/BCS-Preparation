package com.example.bcs_preparation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.view.fragments.FavouriteQuestionPlaylist;

public class FavouriteQuestionPlaylistAdapter extends RecyclerView.Adapter<FavouriteQuestionPlaylistAdapter.FavouriteQuestionPlaylsitViewholder> {

    onfavquesListener itemClickListener;

    public FavouriteQuestionPlaylistAdapter(onfavquesListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public FavouriteQuestionPlaylsitViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_question_playlist,parent,false);
        return new FavouriteQuestionPlaylsitViewholder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteQuestionPlaylsitViewholder holder, int position) {
        holder.playlistBTN.setText("Bangla");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FavouriteQuestionPlaylsitViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Button playlistBTN;
        onfavquesListener itemClickListener;

        public FavouriteQuestionPlaylsitViewholder(@NonNull View itemView, onfavquesListener itemClickListener) {
            super(itemView);
            playlistBTN = itemView.findViewById(R.id.FavQuesPlaylistRecVID);
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {

        }
    }
    public interface onfavquesListener {
        void onClickItem(int position,View view);
    }
}
