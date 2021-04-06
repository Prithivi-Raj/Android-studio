package com.example.animate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    public void fade(View view) {

        Log.i("info", "image pressed");

        { ImageView imageView=(ImageView) findViewById(R.id.imageView);

        ImageView imageView2=(ImageView) findViewById(R.id.imageView2);

        imageView.animate().rotationBy(1800).alpha(1).setDuration(2000);



        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=(ImageView) findViewById(R.id.imageView);

        imageView.setX(-1000);

        imageView.animate().translationXBy(1000).rotationBy(1800).alpha(1).setDuration(2000);



    }
}
