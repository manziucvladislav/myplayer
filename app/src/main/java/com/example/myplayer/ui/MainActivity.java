package com.example.myplayer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ToggleButton;

import com.example.myplayer.R;

public class MainActivity extends AppCompatActivity {

    private static final String APP_PREFERENCES ="app" ;
    private static final String FIRST_RUN ="first_run" ;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFirstRun(true);
        toggleButton = findViewById(R.id.toggle_button);
        toggleButton.setTextOff(getString(R.string.one));
        toggleButton.setTextOn(getString(R.string.many));
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Navigation.findNavController(this,R.id.fragment_container).navigate(R.id.second_fragment_action);
            } else {
                Navigation.findNavController(this,R.id.fragment_container).navigate(R.id.first_fragment_action);
            }
        });
        toggleButton.setChecked(false);
    }
    private void setFirstRun(boolean value){
        SharedPreferences sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(FIRST_RUN,value);
        edit.apply();
    }
}