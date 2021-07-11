package com.saikalyandaroju.customviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.saikalyandaroju.customviews.views.CustomImageView;

public class MainActivity extends AppCompatActivity {


    CustomImageView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       customView=findViewById(R.id.customview);
       customView.setText("Custom Text");
       customView.setImageResource(R.drawable.poster);
       customView.setSize(200,200);


    }



}