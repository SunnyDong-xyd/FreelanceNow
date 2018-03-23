package com.example.sunny.freelancenow;

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
import org.w3c.dom.Text;

import java.io.IOException;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Fetch bundle from MainMenuActivity
        Bundle bundle = getIntent().getExtras();
        String html = bundle.getString("htmlKey");
        //Perm XML variable Definition
        TextView txtView = (TextView)findViewById(R.id.title_text);
        //Temp? XML variable definition
        Button btn1 = (Button)findViewById(R.id.b1_button);
        TextView txtViewD1 = (TextView)findViewById(R.id.d1_text);
        Button btn2 = (Button)findViewById(R.id.b2_button);
        TextView txtViewD2 = (TextView)findViewById(R.id.d2_text);
        Button btn3 = (Button)findViewById(R.id.b3_button);
        TextView txtViewD3 = (TextView)findViewById(R.id.d3_text);

        Log.i("bundled html address",html);
        txtView.setText(html);

        //other variable definition
        String text;


        try {
            // get URL content
            Document doc = Jsoup.connect(html).get();
            text = doc.body().text();
            Log.i("OUTPUT",text);

            final String[] profileList = text.split("\\s*,\\s*");

            btn1.setText(profileList[0]);
            txtViewD1.setText(profileList[1]);
            btn2.setText(profileList[2]);
            txtViewD2.setText(profileList[3]);
            btn3.setText(profileList[4]);
            txtViewD3.setText(profileList[5]);


            /*for(int i=0;i<profileList.length;i++);
            {

            }
            */


            Log.i("test", "done");


        } catch (IOException e) {
            e.printStackTrace();
            Log.i("test", "IOException Error");
        } //end catch
    } //end onCreate
} // end CategoryActivity
