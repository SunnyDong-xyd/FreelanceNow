package com.example.sunny.freelancenow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //Fetch bundle from MainMenuActivity
        Bundle bundle = getIntent().getExtras();
        final String html = bundle.getString("htmlKey");
        //Perm XML variable Definition
        TextView txtView = (TextView)findViewById(R.id.testView);


        txtView.setText(html);
    }
}
