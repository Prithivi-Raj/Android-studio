package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {


MediaPlayer mediaPlayer;

AudioManager audioManager;

    public void play(View view){



            mediaPlayer.start();
        }


        public void pause (View view){



            mediaPlayer.pause();

        }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.praveen);
        audioManager= (AudioManager)getSystemService(AUDIO_SERVICE);

        int maxvolume= audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        int currentvolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumecontrol = (SeekBar) findViewById(R.id.volumeseekBar);

        volumecontrol.setMax(maxvolume);
        volumecontrol.setProgress(currentvolume);
        volumecontrol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("working",Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        final SeekBar scrub = (SeekBar) findViewById(R.id.scrubseekBar);

        scrub.setMax(mediaPlayer.getDuration());

        scrub.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("forward back",Integer.toString(progress));

                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                scrub.setProgress(mediaPlayer.getCurrentPosition());

            }},0, 1000);




}
    }