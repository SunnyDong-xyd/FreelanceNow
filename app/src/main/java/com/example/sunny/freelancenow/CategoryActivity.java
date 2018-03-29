package com.example.sunny.freelancenow;

import android.content.Intent;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
        final String html = bundle.getString("htmlKey");
        //Perm XML variable Definition
        Log.i("bundled html address",html);
        //other variable definition
        String text;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout ll = findViewById(R.id.layout);


        try {
            // get URL content
            Document doc = Jsoup.connect(html).get();
            text = doc.body().text();
            Log.i("OUTPUT",text);
            final String[] profileList = text.split("\\s*,\\s*");

            for (int i = 0; i< profileList.length;i=i+3){
                int profileIndex = i/3;
                int professionIndex = (i/3)+1;
                final int identifierIndex = i+2;
                final String html2 = profileList[identifierIndex];

                //Dynamically Create Button (Properties)
                Button btn = new Button (this);
                btn.setId(profileIndex);
                final int id_ = btn.getId();
                btn.setText(profileList[i]);
                btn.setBackgroundColor(Color.rgb(232,238,247));

                //Dynamically Create TextView
                TextView txt = new TextView(this);
                txt.setId(professionIndex);
                final int id_t = txt.getId();
                txt.setText(profileList[i+1]);
                //txt.getLayoutParams().height = 200;

                //Add created elements to ll
                ll.addView(btn,params);
                ll.addView(txt,params);


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CategoryActivity.this, ProfileActivity.class);
                        String joined = html + "/" + html2;
                        Bundle bundle = new Bundle();
                        bundle.putString("htmlKey",joined);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });

            }





        } catch (IOException e) {
            e.printStackTrace();
            Log.i("test", "IOException Error");
        } //end catch
    } //end onCreate
} // end CategoryActivity
