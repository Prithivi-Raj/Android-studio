package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int random;


    public void generate(){

        Random r= new Random();
        random= r.nextInt(20)+1;

    }


    public void click(View view) {




        EditText editText=(EditText)findViewById(R.id.editText);

        String number= editText.getText().toString();

        int result = Integer.parseInt(number);


        if (result==random) {Toast.makeText(this, "yup you are right", Toast.LENGTH_LONG).show(); generate();}

        else if (result<random) Toast.makeText(this, "higher", Toast.LENGTH_SHORT).show();

        else Toast.makeText(this, "lower", Toast.LENGTH_SHORT).show();

        Log.i("info",Integer.toString(random));

        Log.i("entered",number);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate();



    }
}
