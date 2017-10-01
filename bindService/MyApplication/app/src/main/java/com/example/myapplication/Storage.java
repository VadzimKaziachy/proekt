package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Вадим on 27.09.2017.
 */

public class Storage {
    private static final String KEY_SETTINGS = "A";
    private static final String a = "a";
    private static final String b = "b";

    private static SharedPreferences getShatedPreferences(Context context) {
        if (context != null) {
            return context.getApplicationContext().getSharedPreferences(KEY_SETTINGS, Context.MODE_PRIVATE);
        } else return null;
    }

    public static void setRepository(Context context, float x1) {
        Log.d("Log", " set_1 " + context + " = " + x1);
        SharedPreferences sharedPreferences = getShatedPreferences(context);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat(a, x1).apply();
        }
    }

    public static Float getRepository(Context context) {
        Log.d("Log", "get_1 = " + context);
        SharedPreferences sharedPreferences = getShatedPreferences(context);
        if (sharedPreferences != null) {
            return sharedPreferences.getFloat(a, 0);
        } else return null;
    }

    public static void setB (Context context, float y1){
        Log.d("Log", " set_2 " + context + " = " + y1);
        SharedPreferences sharedPreferences = getShatedPreferences(context);
        if (sharedPreferences != null){
            sharedPreferences.edit().putFloat(b, y1).apply();
        }
    }

    public static Float getB (Context context){
        Log.d("Log", "get_2 = " + context);
        SharedPreferences sharedPreferences = getShatedPreferences(context);
        if (sharedPreferences != null){
            return sharedPreferences.getFloat(b, 0);
        } else return null;
    }

}
