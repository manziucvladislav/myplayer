package com.example.myplayer.ui.fragment.playlist;

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

public class PlaylistRecyclerViewAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    private List<AudioFile> audioFileList;

    public PlaylistRecyclerViewAdapter(List<AudioFile> audioFiles) {
        this.audioFileList = audioFiles;
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_playlist_item, viewGroup, false);

        return new PlaylistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder playlistViewHolder, int i) {
        AudioFile item = getPosition(i);
        Context context = playlistViewHolder.itemView.getContext();
        if (!item.getUrlImage().isEmpty()) {
            Picasso.with(context)
                    .load(item.getUrlImage())
                    .placeholder(R.drawable.user_placeholder)
                    .error(R.drawable.user_placeholder_error)
                    .into(playlistViewHolder.posterImageView);
        }
        playlistViewHolder.singerNameTextView.setText(item.getNameSinger());
        playlistViewHolder.songNameTextView.setText(item.getNameSong());
        String typeStr = String.format(".%s", item.getAudioType().name().toLowerCase());
        playlistViewHolder.typeTextView.setText(typeStr);
        if (context != null) {
            playlistViewHolder.itemView.setOnClickListener(v -> {
                //View androidRobotView = playlistViewHolder.posterImageView;
//                AppCompatActivity activity = (AppCompatActivity) context;
//                FragmentManager fm =activity.getSupportFragmentManager();
//                fm.beginTransaction()
//                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
//                        .replace(R.id.frame, new PlayerListFragment())
//                        .commit();


            });
        }
    }

    private AudioFile getPosition(int position) {
        return audioFileList.get(position);
    }

    @Override
    public int getItemCount() {
        return audioFileList == null ? 0 : audioFileList.size();
    }
}
