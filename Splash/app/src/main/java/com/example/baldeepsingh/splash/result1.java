package com.example.baldeepsingh.splash;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class result1 extends AppCompatActivity {
    TextView textView5;
    MediaPlayer player;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textView5=(TextView)findViewById(R.id.textView5);
        i=(ImageView)findViewById(R.id.imageView4);
        textView5.setText("Result :-" + iit.out + "  Out Of :- " + "100");

        if(iit.out>=50)
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
        startActivity(new Intent(result1.this, List.class));
        finish();
        iit.out=0;

    }
}
