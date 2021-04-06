package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activeplayer = 0;

    int[][] winningposition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};

    int imagestate[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    boolean gamestate = true;

    String name;


    public void dropin(View view) {


        ImageView counter = (ImageView) view;


        int tapcounter = Integer.parseInt(counter.getTag().toString());


        if (imagestate[tapcounter] == 2 && gamestate) {
            counter.setTranslationY(-1000);


            imagestate[tapcounter] = activeplayer;
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.ajith);

                activeplayer = 1;
            } else {

                counter.setImageResource(R.drawable.vijay);


                activeplayer = 0;
            }


            counter.animate().rotation(360).translationYBy(1000).setDuration(500);

            for (int[] jo : winningposition) {

                if (imagestate[jo[0]] == imagestate[jo[1]] && imagestate[jo[1]] == imagestate[jo[2]] && imagestate[jo[0]] != 2) {
                    gamestate = false;

                    if (activeplayer == 1)
                        name = "ajith";
                    else name = "vijay";



                    TextView textView = (TextView) findViewById(R.id.textView);

                    Button button = (Button) findViewById(R.id.button);

                    textView.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);

                    textView.setText(name);


                }

            }
        }}

        public void playagain (View view)
        {

            TextView textView = (TextView) findViewById(R.id.textView);

            Button button = (Button) findViewById(R.id.button);

            textView.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            gamestate = true;

            for(int j=0; j<imagestate.length;j++)

            imagestate[j]=2;


            GridLayout GridLayout1 = (GridLayout) findViewById(R.id.GridLayout1);

            for ( int i = 0; i < GridLayout1.getChildCount(); i++) {
                ImageView counter = (ImageView) GridLayout1.getChildAt(i);

                counter.setImageDrawable(null);


            }


        }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }
