package com.example.myplayer.ui.fragment.playerList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myplayer.R;
import com.example.myplayer.model.AudioFile;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayerListRecyclerViewAdapter extends RecyclerView.Adapter<PlayerListViewHolder> {

    private List<AudioFile> audioFileList;

    public PlayerListRecyclerViewAdapter(List<AudioFile> audioFiles) {
        this.audioFileList = audioFiles;
    }

    @NonNull
    @Override
    public PlayerListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_player_list_item, viewGroup, false);

        return new PlayerListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerListViewHolder playerListViewHolder, int i) {
        AudioFile item = getPosition(i);
        Context context = playerListViewHolder.itemView.getContext();
        if (!item.getUrlImage().isEmpty()) {
            Picasso.with(context)
                    .load(item.getUrlImage())
                    .placeholder(R.drawable.user_placeholder)
                    .error(R.drawable.user_placeholder_error)
                    .into(playerListViewHolder.posterImageView);
        }
        playerListViewHolder.singerNameTextView.setText(item.getNameSinger());
        playerListViewHolder.songNameTextView.setText(item.getNameSong());
    }

    private AudioFile getPosition(int position) {
        return audioFileList.get(position);
    }

    @Override
    public int getItemCount() {
        return audioFileList == null ? 0 : audioFileList.size();
    }
}