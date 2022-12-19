package org.yadav.meth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAllSongs, btnLikedSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAllSongs = findViewById(R.id.btnAllSongs);
        btnLikedSongs = findViewById(R.id.btnLikedSongs);

        btnAllSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllSongsActivity.class);
                startActivity(intent);
            }
        });

        btnLikedSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LikedSongsActivity.class);
                startActivity(intent);
            }
        });
    }
}