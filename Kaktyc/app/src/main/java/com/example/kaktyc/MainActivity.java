package com.example.kaktyc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setClickListeners();
    }
    private void initViews() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

    }

    private void setClickListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button1:
                        Intent intent1 = new Intent(MainActivity.this, Main1Activity.class);
                        startActivity(intent1);
                        overridePendingTransition(R.anim.vpered,0); //метод который позволяет подключить анимацию для переходов, анимация прописывается в папке anim, вместо нуля можно посвить еще какую-нибудь анимацию
                        break;
                    case R.id.button2:
                        Intent intent2 = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent2);
                        overridePendingTransition(R.anim.vpered,0);
                        break;
                    case R.id.button3:
                        //Intent intent3 = new Intent(MainActivity.this, Main3Activity.class);
                        //startActivity(intent3);
                        //overridePendingTransition(R.id.vpered,0);
                    default:
                        break;
                }

            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
    }
}
