package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Boolean active= false;CountDownTimer countDownTimer;
    SeekBar seekBar;
    TextView textView;
    MediaPlayer mediaPlayer;
Button button;
    public void reset(){

        button.setText("go");
        seekBar.setProgress(30);
        countDownTimer.cancel();
        seekBar.setEnabled(true);
        active=false;


    }

    public void click(View view){
        if(active){ reset();

        }else{ active=true;button.setText("stop");

        seekBar.setEnabled(false);

     countDownTimer=new CountDownTimer(seekBar.getProgress()*1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

                update((int) millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {


mediaPlayer.start(); reset();
            }
        }.start();


    }}
    public void update(int mama){
        int min= mama/60;
        int sec= mama-(min*60);
        String second= Integer.toString(sec);

        if(sec<10)
        { second="0"+second;}
        textView.setText(Integer.toString(min)+":"+ second);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer= MediaPlayer.create(this,R.raw.sanda);
        seekBar=(SeekBar)findViewById(R.id.seek);
        textView=(TextView)findViewById(R.id.textView);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        button= (Button)findViewById(R.id.button);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                update(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
