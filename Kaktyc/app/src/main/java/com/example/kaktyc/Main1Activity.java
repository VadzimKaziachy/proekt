package com.example.kaktyc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Main1Activity extends AppCompatActivity {
    Button button;
    Button button2;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        initViews();
        pekaco();
        setClickListeners();
    }

    private void initViews() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);

    }
    private void pekaco(){
        Picasso.with(this)
                .load(R.drawable.qwor)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView1);
        Picasso.with(this)
                .load(R.drawable.wwor)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView2);
        Picasso.with(this)
                .load(R.drawable.erwor)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView3);
        Picasso.with(this)
                .load(R.drawable.pwor)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView4);
        Picasso.with(this)
                .load(R.drawable.awor)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView5);
    }

    private void setClickListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button:
                        Intent intent = new Intent(Main1Activity.this, MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.nazat,0);
                        break;
                    case R.id.button2:
                        Intent intent1 = new Intent(Main1Activity.this, Main12Activity.class);
                        startActivity(intent1);
                        overridePendingTransition(R.anim.vpered,0);
                        break;

                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
    }
}
