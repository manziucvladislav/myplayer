package com.example.myplayer.ui.fragment.playlist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myplayer.R;

public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    public ImageView posterImageView;
    public TextView singerNameTextView;
    public TextView songNameTextView;
    public TextView typeTextView;

    public PlaylistViewHolder(@NonNull View itemView) {
        super(itemView);
        ini(itemView);
    }

    private void ini(View view) {
        posterImageView = view.findViewById(R.id.poster_image_view);
        singerNameTextView = view.findViewById(R.id.name_singer_text_view);
        songNameTextView = view.findViewById(R.id.name_song_text_view);
        typeTextView = view.findViewById(R.id.type_text_view);
    }
}