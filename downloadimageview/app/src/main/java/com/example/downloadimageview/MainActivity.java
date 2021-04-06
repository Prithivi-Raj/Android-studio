package com.example.downloadimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    public void click(View view){

        Imagedownload imagedownload=new Imagedownload();
        Bitmap myimage;

        try {
            myimage= imagedownload.execute("https://i1.wp.com/www.socialnews.xyz/wp-content/uploads/2019/05/29/Aamir-Khan-s-daughter-Ira-Khan-Latest-Still-.jpg?quality=90&zoom=1&ssl=1").get();
            imageView.setImageBitmap(myimage);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView);
    }

    public class Imagedownload extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url= new URL(urls[0]);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in= connection.getInputStream();
                Bitmap bitmap= BitmapFactory.decodeStream(in);
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }
}
