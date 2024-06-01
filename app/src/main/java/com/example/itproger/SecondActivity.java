package com.example.itproger;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private ImageButton photo;
    private MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        photo = findViewById(R.id.soundButton);
        sound = MediaPlayer.create(this, R.raw.sample);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override // проигрывание звуковых эффектов
            public void onClick(View v) {
                soundPlayButton(sound);
            }
        });
    }

    private void soundPlayButton(MediaPlayer sound) {
        if (sound.isPlaying()) {
            sound.stop(); // если играет, то выключаем
        } else {
            sound.start(); // переданную мелодию
            sound.setLooping(false); // будет ли много раз играть
        }
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}