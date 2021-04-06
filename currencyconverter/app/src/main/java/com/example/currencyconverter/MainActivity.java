package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view) {

        Log.i("info", "button pressed");

        EditText editText = (EditText) findViewById(R.id.editText);

        String amountineuro = editText.getText().toString();

        Double amountineurodouble = Double.parseDouble(amountineuro);

        Double amountindollardouble = amountineurodouble * 1.3;

        String amountindollar = String.format("%.2f", amountindollardouble);

        Toast.makeText(this, "euro" + amountineuro + "is dollar"+ amountindollar , Toast.LENGTH_LONG).show();




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
