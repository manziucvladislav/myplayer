package com.example.myplayer.storage;

import com.example.myplayer.enums.AudioType;
import com.example.myplayer.model.AudioFile;

import java.util.ArrayList;
import java.util.List;

public class AudioFileStorage {
    public static List<AudioFile> getAudioFileList() {
        List<AudioFile> audioFiles = new ArrayList<>();
        audioFiles.add(new AudioFile(
                "https://zaycev.net/commonImage/119641_square250.jpg",
                "Ирина Дубцова",
                "Люби меня долго",
                AudioType.MP3));
        audioFiles.add(new AudioFile(
                "https://zaycev.net/commonImage/40547_square250.jpg",
                "Elvira T",
                "Такси",
                AudioType.MP3));
        audioFiles.add(new AudioFile(
                "https://zaycev.net/commonImage/122477_square250.jpg",
                "Макс Барских",
                "Теряю тебя",
                AudioType.MP3));
        audioFiles.add(new AudioFile(
                "https://zaycev.net/commonImage/131546_square250.jpg",
                "Фабрика",
                "Про любовь",
                AudioType.MP3));

        audioFiles.add(new AudioFile(
                "https://zaycev.net/commonImage/115974_square250.jpg",
                "Город 312",
                "Мама",
                AudioType.MP3));

        audioFiles.add(new AudioFile(
                "",
                "Иванушки  International",
                "Золотые облака",
                AudioType.MP3));

        audioFiles.add(new AudioFile(
                "https://zaycev.net/commonImage/album/track/4099/square800.jpg",
                "Руки Вверх",
                "Плачешь в темноте",
                AudioType.MP3));
        audioFiles.add(new AudioFile(
                "https://zaycev.net/commonImage/album/track/3730/square800.jpg",
                "Дима Билан",
                "Лови мои мечты",
                AudioType.MP3));

        audioFiles.add(new AudioFile(
                "https://zaycev.net/commonImage/1227216_square250.jpg",
                "MIA BOYKA",
                "Дикая ламба",
                AudioType.MP3));

        audioFiles.add(new AudioFile(
                "https://zaycev.net/commonImage/album/track/12807/square800.jpg",
                "Reflex",
                "Падали звезды",
                AudioType.MP3));

        return audioFiles;
    }
}
