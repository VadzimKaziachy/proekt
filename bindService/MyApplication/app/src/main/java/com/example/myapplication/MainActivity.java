package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.library_oo.FileOo;

public class MainActivity extends AppCompatActivity implements FileOo.Callbacks {

    boolean mBound;
    boolean clickButton = true;
    Button button, button2, button3;
    TextView textview;

    FileOo myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        textview = (TextView) findViewById(R.id.textView);
        setOnClickListeners();
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            FileOo.MyBinder binder = (FileOo.MyBinder) service; //получаем данные с сервиса
            myBinder = binder.getService();
            myBinder.registetClient(MainActivity.this); //регестрируем сервис
            mBound = true;
            Log.d("Log", "произощел конект с сервисом в методе onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
            Log.d("Log", " произошел дисконект с сервисом в методе onServiceDisconnected");
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(MainActivity.this, FileOo.class), mConnection, Context.BIND_AUTO_CREATE); //подключаемся к сервису
        Log.d("Log", "возрадилось активити в методе onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection); //отключаемся от сервиса
            mBound = false;
            Log.d("Log", "остановилось сервис в методе onStop");
        }
    }

    private void setOnClickListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickButton){ //проверям сколько раз нажимали на кнопку
                    startService(new Intent(MainActivity.this, FileOo.class)); //стартуем сервис
                    Log.d("Log", "стартанул сервис в кнопке");
                    clickButton = false;
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound) { //проверяем жив ли сервис
                    unbindService(mConnection); //отключаемся от сервиса
                    mBound = false;
                    stopService(new Intent(MainActivity.this, FileOo.class)); //останавливаем сервис
                    Log.d("Log", "остановилось сервис в кнопке ");
                    bindService(new Intent(MainActivity.this, FileOo.class), mConnection, Context.BIND_AUTO_CREATE); //подключаемся к сервису
                    Log.d("Log", "возражидось подключение к сервису в кнопке");

                }
                clickButton = true;
            }
        });
    }

    @Override
    public void updateClient(long data) { //метод где реализуем сервис
        textview.setText(String.valueOf(data));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Log", "уничтожилась активити в методе onDestroy");
    }
}
