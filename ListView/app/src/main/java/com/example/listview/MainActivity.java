package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.mylistview);

        final ArrayList<String> kan = new ArrayList<String>();
        kan.add("aiyo");
        kan.add("jojo");
        kan.add("koko");
        kan.add("popo");
        kan.add("dodo");



        final ArrayAdapter<String>  arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,kan);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i("info",kan.get(position));
            }
        });

    }
}
