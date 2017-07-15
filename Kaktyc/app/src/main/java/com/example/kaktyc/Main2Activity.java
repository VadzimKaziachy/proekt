package com.example.kaktyc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
    Button button4, button5;
    ImageView imageView12, imageView13,imageView14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        one();
        pekaco();
        setClickListeners();
    }
    private void one(){
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        imageView12 = (ImageView) findViewById(R.id.imageView12);
        imageView13 = (ImageView) findViewById(R.id.imageView13);
        imageView14 = (ImageView) findViewById(R.id.imageView14);
    }
    private  void pekaco() {//подключаем библиотеку  Picasso и открывыем кратинку с загрузкой
        Picasso.with(this)
                .load(R.drawable.za)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView12);
        Picasso.with(this)
                .load(R.drawable.zs)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView13);
        Picasso.with(this)
                .load(R.drawable.zd)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView14);
    }

    private void setClickListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.nazat,0);
                        break;
                    case R.id.button4:
                        Intent intent1 = new Intent(Main2Activity.this, Main22Activity.class);
                        startActivity(intent1);
                        overridePendingTransition(R.anim.vpered,0);
                        break;

                }
            }
        };
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
    }
}

