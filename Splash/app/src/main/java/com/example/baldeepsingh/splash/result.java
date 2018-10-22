package com.example.baldeepsingh.splash;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView textView2;
    MediaPlayer player;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textView2=(TextView)findViewById(R.id.textView2);
        textView2.setText("Result :-" + Genral.out + "  Out Of :-  " + "100");
        i=(ImageView)findViewById(R.id.imageView3);
        if(Genral.out>=50)
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
        startActivity(new Intent(result.this, List.class));
        finish();
        Genral.out=0;
    }
}
