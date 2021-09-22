package com.example.myplayer.model;

import com.example.myplayer.enums.AudioType;

public class AudioFile {
    private String urlImage;
    private String nameSinger;
    private String nameSong;
    private AudioType audioType;

    public AudioFile(String urlImage, String nameSinger, String nameSong, AudioType audioType) {
        this.urlImage = urlImage;
        this.nameSinger = nameSinger;
        this.nameSong = nameSong;
        this.audioType = audioType;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public AudioType getAudioType() {
        return audioType;
    }

    public void setAudioType(AudioType audioType) {
        this.audioType = audioType;
    }
}
