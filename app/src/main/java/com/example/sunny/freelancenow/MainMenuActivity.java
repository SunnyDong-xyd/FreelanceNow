package com.example.sunny.freelancenow;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;


public class MainMenuActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        TextView txtView = (TextView)findViewById(R.id.txtView);
        Button btn = (Button)findViewById(R.id.buttonc1);
        Button btn2 = (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this, CategoryActivity.class));
            }
        });





    /*    URL url;

        try {
            // get URL content
            Log.i("test", "1");
            String a="http://192.168.56.1:8000/info/";
            url = new URL(a);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                Log.d("OUTPUT",inputLine);
            }
            br.close();

            Log.d("DONE","done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.i("test", "test1");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("test", "test2");
        }

*/

        String text;
        try {
            // get URL content

            Document doc = Jsoup.connect("http://10.217.80.89:8000/info/").get();
            text = doc.body().text();
            String[] categoryList = text.split("\\s*,\\s*");

            Log.i("OUTPUT",text);
            btn.setText(categoryList[0]);

            btn2.setText(categoryList[2]);



        /*
            for (Element table : doc.select("table")){
                for (Element rows : table.select("tr")) {
                    Elements tds = rows.select("td");
                    text = tds.text();
                    Log.i("OUTPUT",text);
                    categoryList = text.split("\\s*,\\s*");

                }
                Log.i("no",categoryList[0]);
                String str = categoryList[0];
                btn.setText(categoryList[0]);


                    String L = Integer.toString(categoryList.length);
                    Log.i("OUTPUT",L);
                    for (int i=0;i<categoryList.length;i++){
                        Log.i("OUTPUT",categoryList[i]);
                        String sample = categoryList[i];

                    }

            }
            */




            Log.i("test", "done");




        } catch (IOException e) {
            e.printStackTrace();
            Log.i("test", "IOExceptionm");
        }

    }

}