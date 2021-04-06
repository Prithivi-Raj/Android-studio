package com.example.interactivitydemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    public fun clickfunction(view: View) {

        val nameEditText = findViewById<EditText>(R.id.nameEditText);

        Log.i("info","correct");

        Log.i("values",nameEditText.text.toString());


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }
}
