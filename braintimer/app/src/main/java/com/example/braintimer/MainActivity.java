package com.example.braintimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView count;
    int locationofanswer;
    TextView result;
    TextView random;
    TextView mark;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button;
    int numerator;
    int denominator;
    int kusu;

    ArrayList<String> arrayList = new ArrayList<String>();

      CountDownTimer countDownTimer=new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
              count.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                result.setVisibility(View.VISIBLE);
                result.setText("done");
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button.setVisibility(View.VISIBLE);
                button.setText("play again");
                denominator=0;
                numerator=0;
                mark.setText("0/0");


            }
        };



      public void click(View kuska){

          countDownTimer.start();
          button2.setVisibility(View.VISIBLE);
          button3.setVisibility(View.VISIBLE);
          button4.setVisibility(View.VISIBLE);
          button5.setVisibility(View.VISIBLE);
          button2.setEnabled(true);
          button3.setEnabled(true);
          button4.setEnabled(true);
          button5.setEnabled(true);
          button.setVisibility(View.INVISIBLE);
          result.setVisibility(View.VISIBLE);
          result.setText("");
          mark.setVisibility(View.VISIBLE);
        kusu= rand.nextInt(4);

          int randomnumber1 = rand.nextInt(20);
          int randomnumber2 = rand.nextInt(20);

          int answer = randomnumber1 + randomnumber2;

          String l = Integer.toString(randomnumber2) + "+" + Integer.toString(randomnumber1);

          random.setText(l);
          kusu = locationofanswer;

          locationofanswer = rand.nextInt(4);

          for (int i = 0; i < 4; i++) {
              if (i == locationofanswer) {
                  arrayList.add(Integer.toString(answer));
              } else {
                  int wronganswer = rand.nextInt(40);
                  while (wronganswer == answer) {
                      wronganswer = rand.nextInt(40);
                  }

                  arrayList.add(Integer.toString(wronganswer));

              }
          }


          button2.setText(arrayList.get(0));
          button3.setText(arrayList.get(1));
          button4.setText(arrayList.get(2));
          button5.setText(arrayList.get(3));


          arrayList.clear();



      }

      Random rand= new Random();

      public void option(View asd) {
          denominator++;

          int randomnumber1 = rand.nextInt(20);
          int randomnumber2 = rand.nextInt(20);

          int answer = randomnumber1 + randomnumber2;

          String l = Integer.toString(randomnumber2) + "+" + Integer.toString(randomnumber1);

          random.setText(l);
          kusu = locationofanswer;

          locationofanswer = rand.nextInt(4);

          for (int i = 0; i < 4; i++) {
              if (i == locationofanswer) {
                  arrayList.add(Integer.toString(answer));
              } else {
                  int wronganswer = rand.nextInt(40);
                  while (wronganswer == answer) {
                      wronganswer = rand.nextInt(40);
                  }

                  arrayList.add(Integer.toString(wronganswer));

              }
          }


          button2.setText(arrayList.get(0));
          button3.setText(arrayList.get(1));
          button4.setText(arrayList.get(2));
          button5.setText(arrayList.get(3));


          arrayList.clear();


          if (asd.getTag().toString().equals(Integer.toString(kusu))) {

              result.setText("correct");
              numerator++;

          } else {
              result.setText("wrong");

          }
          mark.setText(Integer.toString(numerator) + "/" + Integer.toString(denominator));
      }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count =(TextView)findViewById(R.id.count);
        result= (TextView)findViewById(R.id.result);
        random=(TextView)findViewById(R.id.random);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button=(Button)findViewById(R.id.button);
        mark=(TextView)findViewById(R.id.mark);


    }
}
