package com.example.guessthecelebrity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Random random;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    String wronganswer;


    ImageView kaka;
    int locationofanswer;

    ArrayList<String> celebname = new ArrayList<String>();
    ArrayList<String> celeburl = new ArrayList<String>();


    public class Downloadtask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            String result = "";
            URL url;
            HttpURLConnection connection;

            try {
                url= new URL(strings[0]);
                connection=(HttpURLConnection) url.openConnection();
                InputStream in= connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data= reader.read();

                while (data!=-1) {

                    char current = (char) data;
                    result+=current;
                    data=reader.read();
                }

                return result;
                }

                catch (Exception e) {
                e.printStackTrace();
                return "failed";
            }

        }
    }


    public class Downloadimage extends AsyncTask<String,Void,Bitmap>{


        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url= new URL(urls[0]);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.connect();
                InputStream in= connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                return bitmap;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }

    public void f(){

        try {
            Downloadimage imagetask= new Downloadimage();

            int rand= random.nextInt(celeburl.size());


            Bitmap kusu= imagetask.execute(celeburl.get(rand)).get();
            kaka.setImageBitmap(kusu);

            String answer= celebname.get(rand);
            wronganswer= celebname.get(random.nextInt(celeburl.size()));


            locationofanswer= random.nextInt(3)+1;

            if(button1.getTag().toString().equals(Integer.toString(locationofanswer)))

                button1.setText(answer);
            else
            {
                while(!wronganswer.equals(answer))
                { button1.setText(wronganswer);
                    wronganswer= celebname.get(random.nextInt(celeburl.size()));
                    break;
                }}
            if(button2.getTag().toString().equals(Integer.toString(locationofanswer)))

                button2.setText(answer);
            else
            {
                while(!wronganswer.equals(answer))
                { button2.setText(wronganswer);
                    wronganswer= celebname.get(random.nextInt(celeburl.size()));
                    break;
                }
            }
            if(button3.getTag().toString().equals(Integer.toString(locationofanswer)))

                button3.setText(answer);
            else
            {
                while(!wronganswer.equals(answer))
                { button3.setText(wronganswer);
                    wronganswer= celebname.get(random.nextInt(celeburl.size()));
                    break;}}

            if(button4.getTag().toString().equals(Integer.toString(locationofanswer)))

                button4.setText(answer);
            else
            {
                while(!wronganswer.equals(answer))
                { button4.setText(wronganswer);
                    wronganswer= celebname.get(random.nextInt(celeburl.size()));
                    break;
                }}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void click(View view) {

        f();

        if (view.getTag().toString().equals(Integer.toString(locationofanswer))) {

            Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();

        }else Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kaka= (ImageView)findViewById(R.id.imageView);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);

        random=new Random();


        Downloadtask task =new Downloadtask();
        String result=null;


        try {
            result=task.execute("http://www.posh24.se/kandisar").get();

            String split[]=result.split("<div class=\"listedArticle\">");
            String maka[]=split[0].split("<a href=\"/kandisar/a_till_o\" class=\"link\">Kändisar A-Ö</a>");


            Pattern p= Pattern.compile("<img src=\"(.*?)\"");
            Matcher m= p.matcher(maka[1]);

            while (m.find()){

                celeburl.add(m.group(1));
            }


            p= Pattern.compile("<a href=\"/(.*?)\">");
            m= p.matcher(maka[1]);

            while (m.find()){

                celebname.add(m.group(1));
            }

            f();





        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
