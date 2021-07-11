package com.saikalyandaroju.customviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

import com.saikalyandaroju.customviews.views.CustomView;

public class MainActivity extends AppCompatActivity {


    CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customView=findViewById(R.id.customview);

    }


    public void change(View view) {
        customView.changeColor();
    }
}