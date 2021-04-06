package com.example.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new CountDownTimer(10000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("remainnngg",Long.toString(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Log.i("otha oevre","sjsj");
            }
        }.start();

       /* final Handler handler= new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {

                Log.i("hh","second");
                handler.postDelayed(this,1000);

            }

        };handler.post(runnable);*/

    }
}
