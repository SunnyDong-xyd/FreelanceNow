package com.example.sunny.freelancenow;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;



public class MainMenuActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        TextView txtView = findViewById(R.id.txtView);
        Button btn = findViewById(R.id.buttonc1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);





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
            final String htmlAddress = "http://130.15.43.232:8000/info/";
            Document doc = Jsoup.connect(htmlAddress).get();
            text = doc.body().text();
            final String[] categoryList = text.split("\\s*,\\s*");

            Log.i("OUTPUT",text);
            btn.setText(categoryList[0]);
            btn2.setText(categoryList[2]);
            btn3.setText(categoryList[4]);
            btn4.setText(categoryList[6]);
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

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainMenuActivity.this, CategoryActivity.class);
                    String joined = htmlAddress + categoryList[1];
                    Bundle bundle = new Bundle();
                    bundle.putString("htmlKey",joined);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    //startActivity(new Intent(MainMenuActivity.this, CategoryActivity.class));
                }
            });


            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainMenuActivity.this, CategoryActivity.class);
                    String joined = htmlAddress + categoryList[3];
                    Bundle bundle = new Bundle();
                    bundle.putString("htmlKey",joined);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainMenuActivity.this, CategoryActivity.class);
                    String joined = htmlAddress + categoryList[5];
                    Bundle bundle = new Bundle();
                    bundle.putString("htmlKey",joined);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainMenuActivity.this, CategoryActivity.class);
                    String joined = htmlAddress + categoryList[7];
                    Bundle bundle = new Bundle();
                    bundle.putString("htmlKey",joined);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            Log.i("test", "IOException Error");
        }

    }

}