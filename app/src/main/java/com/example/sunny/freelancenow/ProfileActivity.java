package com.example.sunny.freelancenow;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        //Fetch bundle from MainMenuActivity
        Bundle bundle = getIntent().getExtras();
        final String html = bundle.getString("htmlKey");
        String text;
        //Perm XML variable Definition
        TextView txt_name = findViewById(R.id.name_text);
        TextView txt_job = findViewById(R.id.job_text);
        TextView txt_email = findViewById(R.id.email_text);
        TextView txt_location = findViewById(R.id.location_text);
        TextView txt_payment = findViewById(R.id.payment_text);
        RatingBar rating_b = findViewById(R.id.ratingBar);
        TextView txt_bio = findViewById(R.id.bio_text);


        Log.i("bundled html address",html); //Test Output


        try {
            // get URL content
            Document doc = Jsoup.connect(html).get();
            text = doc.body().text();
            Log.i("OUTPUT",text);
            final String[] infoList = text.split("\\s*~\\s*");

            txt_name.setText(infoList[0]);
            txt_job.setText(infoList[1]);
            txt_email.setText(infoList[2]);
            txt_location.setText(infoList[3]);
            txt_payment.setText(infoList[4]);

            Float rating_f = Float.parseFloat(infoList[5]);

            rating_b.setRating(rating_f);
            txt_bio.setText(infoList[6]);






        }
            catch (IOException e) {
            e.printStackTrace();
            Log.i("test", "IOException Error");
        } //end catch



    }
}
