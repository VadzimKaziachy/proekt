package com.example.library_oo;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Вадим on 30.09.2017.
 */

public class FileOo extends Service {

    private final IBinder mBinder = new MyBinder();
    private Handler mHandler = new Handler();
    Callbacks activity;
    long i;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timeUpdaterRunnable.run();
        return START_NOT_STICKY;
    }

    private Runnable timeUpdaterRunnable = new Runnable() {
        @Override
        public void run() {
            i++;
            activity.updateClient(i); //отправдяем объект
            mHandler.postDelayed(this, 100);
        }
    };

    public void registetClient(Activity activity){
        this.activity = (Callbacks)activity;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(timeUpdaterRunnable); //останавливаем Handler
        Log.d("Log", "уничтожился сервис в классе FileOo в методе onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT).show();
        return mBinder; // тут пишем объект класс
    }

    public interface Callbacks { //создаем интерфейс, через его будет передавать значения
        void updateClient(long data); //в параметрах пишем то что хотим передовать
    }

    public class MyBinder extends Binder {
        public FileOo getService() {
            return FileOo.this;
        }
    }
};

