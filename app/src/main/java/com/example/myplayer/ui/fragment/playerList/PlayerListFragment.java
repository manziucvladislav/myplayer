package com.example.myplayer.ui.fragment.playerList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myplayer.R;
import com.example.myplayer.model.AudioFile;
import com.example.myplayer.storage.AudioFileStorage;

import java.util.List;

public class PlayerListFragment extends Fragment {

    private RecyclerView playerListRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playerListRecyclerView = view.findViewById(R.id.player_list_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false);
        playerListRecyclerView.setLayoutManager(layoutManager);
        final List<AudioFile> audioFileList = getAudioFileList();
        PlayerListRecyclerViewAdapter adapter = new PlayerListRecyclerViewAdapter(audioFileList);
        playerListRecyclerView.setAdapter(adapter);
    }

    private List<AudioFile> getAudioFileList() {
        return AudioFileStorage.getAudioFileList();
    }
}