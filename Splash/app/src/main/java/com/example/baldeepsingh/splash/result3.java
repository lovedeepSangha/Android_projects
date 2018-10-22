package com.example.baldeepsingh.splash;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class result3 extends AppCompatActivity {
    TextView textView7;
    MediaPlayer player;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result3);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textView7=(TextView)findViewById(R.id.textView7);
        i=(ImageView)findViewById(R.id.imageView6);
        textView7.setText("Result :-" + bollywood.out + "  Out Of :- " + "100");

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        if(bollywood.out>=50)
        {
            i.setImageResource(getResources().getIdentifier("cong", "drawable", getPackageName()));
            setVolumeControlStream(AudioManager.STREAM_MUSIC);

            player = MediaPlayer.create(this, R.raw.c);

            player.start();
        }
        else
        {
            i.setImageResource(getResources().getIdentifier("loser", "drawable", getPackageName()));
            setVolumeControlStream(AudioManager.STREAM_MUSIC);

            player = MediaPlayer.create(this, R.raw.h);

            player.start();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (this.isFinishing()){
            player.stop();
        }
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(result3.this, List.class));
        finish();
        bollywood.out=0;

    }
}
