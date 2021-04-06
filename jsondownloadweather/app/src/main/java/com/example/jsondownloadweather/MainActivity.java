package com.example.jsondownloadweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class Downloadjson extends AsyncTask<String,Void,String>{


        @Override
        protected String doInBackground(String... urls) {
            try {
                String result="";
                URL url=new URL(urls[0]);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                InputStream in=connection.getInputStream();
                InputStreamReader reader =new InputStreamReader(in);
                int data= reader.read();

                while (data!=-1){

                    char current= (char)data;
                    result+=current;
                    data=reader.read();
                }
                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return "failed";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject= new JSONObject(s);
                String weatherinfo= jsonObject.getString("weather");

                JSONArray array= new JSONArray(weatherinfo);

                for(int i=0;i<array.length();i++){

                    JSONObject jsonpart= array.getJSONObject(i);
                    Log.i("main",jsonpart.getString("main"));
                    Log.i("desc",jsonpart.getString("description"));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String result=null;
        Downloadjson task= new Downloadjson();
        try {
            result= task.execute("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

}
}
