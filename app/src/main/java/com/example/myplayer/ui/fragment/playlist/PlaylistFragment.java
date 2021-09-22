package com.example.myplayer.ui.fragment.playlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myplayer.R;
import com.example.myplayer.model.AudioFile;
import com.example.myplayer.storage.AudioFileStorage;

import java.util.List;

public class PlaylistFragment extends Fragment {

    private RecyclerView playlistRecyclerView;
    private static final String APP_PREFERENCES ="app" ;
    private static final String FIRST_RUN ="first_run" ;
    private boolean firstRun;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if(arguments!=null){
            firstRun = arguments.getBoolean("first_run",false);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playlistRecyclerView = view.findViewById(R.id.playlist_recycler_view);
        playlistRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final List<AudioFile> audioFileList = getAudioFileList();
        PlaylistRecyclerViewAdapter adapter = new PlaylistRecyclerViewAdapter(audioFileList);
        playlistRecyclerView.setAdapter(adapter);
        if(isFirstRun()){
            setFirstRun(false);
            int size = audioFileList.size();
            int i = getIntRandom(size);
            AudioFile audioFile = audioFileList.get(i);
            String message = String.format("Featured Song today: %s \n %s",audioFile.getNameSinger(),audioFile.getNameSong());
            Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
        }
    }

    private boolean isFirstRun(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(FIRST_RUN,false);
    }

    private void setFirstRun(boolean value){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(FIRST_RUN,value);
        edit.apply();
    }

    private int getIntRandom(int max){
        return (int) (Math.random() * max);
    }

    private List<AudioFile> getAudioFileList(){
        return AudioFileStorage.getAudioFileList();
    }
}