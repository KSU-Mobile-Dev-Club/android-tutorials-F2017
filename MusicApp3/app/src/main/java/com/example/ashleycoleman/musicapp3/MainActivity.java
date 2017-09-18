package com.example.ashleycoleman.musicapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isPlaying = false;

    int index = 2;
    String[] songs = {"Flicker", "Sad Machine", "Years of War", "Lionhearted", "Goodbye To A World"};

    TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton previousButton = (ImageButton)findViewById(R.id.previousImageButton);
        final ImageButton playButton = (ImageButton)findViewById(R.id.playImageButton);
        ImageButton nextButton = (ImageButton)findViewById(R.id.nextImageButton);

        ImageView albumImageView = (ImageView)findViewById(R.id.albumArtImageView);

        TextView authorTextView = (TextView)findViewById(R.id.authorTextView);
        titleTextView = (TextView)findViewById(R.id.titleTextView);

        // Assign song info

        titleTextView.setText(songs[index]);
        authorTextView.setText("Porter Robinson");

        albumImageView.setImageResource(R.drawable.worlds_porter_robinson);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPlaying = !isPlaying;

                if(isPlaying) {
                    playButton.setImageResource(android.R.drawable.ic_media_pause);
                } else {
                    playButton.setImageResource(android.R.drawable.ic_media_play);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                titleTextView.setText(songs[index]);
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                titleTextView.setText(songs[index]);
            }
        });
    }
}
