package com.example.kaktyc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Main0Activity extends AppCompatActivity {

    ImageView imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);

        one();
        two();
        three();
    }
    private void one(){
        imageView6 = (ImageView) findViewById(R.id.imageView6);
    }
    private void two(){
        Animation aima = null;
        aima = AnimationUtils.loadAnimation(Main0Activity.this, R.anim.animatua);
        imageView6.startAnimation(aima);
    }

    private void three(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Main0Activity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },2*1000);
    }




}
