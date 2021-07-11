package com.saikalyandaroju.customviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


}
/*
 To add animations to a view.
        //Animation
      Animation  topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);


        img.setAnimation(topAnim);

 */