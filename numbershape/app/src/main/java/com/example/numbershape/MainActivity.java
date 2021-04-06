package com.example.numbershape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     public class avaninth{

         int n;
         int y;

    boolean triangular() {

        int x = 1;
        int triangle = 1;

        while (triangle < n) {

            x++;
            triangle += x;

            if (triangle == n)
                y = 1;
            else
                y = 2;
        }

        if (y == 1) return true;
        else return false;
    }



     boolean checkPerfectSquare()
    {

        // finding the square root of given number
        double sq = Math.sqrt(n);

        /* Math.floor() returns closest integer value, for
         * example Math.floor of 984.1 is 984, so if the value
         * of sq is non integer than the below expression would
         * be non-zero.
         */
        return ((sq - Math.floor(sq)) == 0);
    }

     }
    public void click(View view){

        EditText editText=(EditText)findViewById(R.id.editText);

        String number= editText.getText().toString();


        Log.i("number",number);

        avaninth a = new avaninth();
        a.n= Integer.parseInt(number);

        if (a.triangular())
            Toast.makeText(this, "triangular", Toast.LENGTH_SHORT).show();

        else Toast.makeText(this, "not triangular", Toast.LENGTH_SHORT).show();

        if (a.checkPerfectSquare())

            Toast.makeText(this, "sqaure", Toast.LENGTH_SHORT).show();

        else Toast.makeText(this, "not square", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}
