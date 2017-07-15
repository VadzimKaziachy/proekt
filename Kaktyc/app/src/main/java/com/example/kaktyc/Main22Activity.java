package com.example.kaktyc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static com.example.kaktyc.R.id.editText15;

public class Main22Activity extends AppCompatActivity {
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, editText12, editText13, editText14;
    Button button1, button2, button3;
    ImageView imageView, imageView8;

    double a, Tct, Tv, D, L, Tcp, p, Cp, betta, gamma, v, GrPr, Nu, alfa, Q, Tcp1, p1, Cp1, betta1, gamma1, v1, GrPr1, Nu1, alfa1, Q1, Pr, n, C;

    final String SAVED_TEXT = "saved_text";
    SharedPreferences Tct2, Tv2, D2, L2, Tcp2, p2, Cp2, betta2, gamma2, v2, GrPr2, Nu2, alfa2, Q2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        nachalo();
        pekaco();
        vuvod();
        setClickListeners();
    }

    private void nachalo() {
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText11 = (EditText) findViewById(R.id.editText11);
        editText12 = (EditText) findViewById(R.id.editText12);
        editText13 = (EditText) findViewById(R.id.editText13);
        editText14 = (EditText) findViewById(R.id.editText14);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
    }
    private  void pekaco() {//подключаем библиотеку  Picasso и открывыем кратинку с загрузкой
        Picasso.with(this)
                .load(R.drawable.tad1)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView);
        Picasso.with(this)
                .load(R.drawable.tad2)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView8);
    }

    private void setClickListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button1:
                        coxranenue();
                        Intent intent = new Intent(Main22Activity.this, Main2Activity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.nazat,0);
                        break;
                    case R.id.button2:
                        random();
                        break;
                    case R.id.button3:
                        proverka();
                        break;

                }
            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
    }

    private void random() {
        editText1.setText(String.valueOf(300 + (int) (Math.random() * ((1500 - 300) + 1))));
        a = Float.parseFloat(editText1.getText().toString());
        editText2.setText(String.valueOf(273 + (int) (Math.random() * ((a - 273) + 1))));
        editText3.setText(String.valueOf(1 + (int) (Math.random() * ((3 - 1) + 1))));
        editText4.setText(String.valueOf(1 + (int) (Math.random() * ((1000 - 1) + 1))));
        editText5.setText(String.valueOf(0));
        editText6.setText(String.valueOf(0));
        editText7.setText(String.valueOf(0));
        editText8.setText(String.valueOf(0));
        editText9.setText(String.valueOf(0));
        editText10.setText(String.valueOf(0));
        editText11.setText(String.valueOf(0));
        editText12.setText(String.valueOf(0));
        editText13.setText(String.valueOf(0));
        editText14.setText(String.valueOf(0));
    }

    private void proverka() {
        try {
            Tct = Float.parseFloat(editText1.getText().toString());
            Tv = Float.parseFloat(editText2.getText().toString());
            D = Float.parseFloat(editText3.getText().toString());
            L = Float.parseFloat(editText4.getText().toString());

            Tcp1 = Float.parseFloat(editText5.getText().toString());
            p1 = Float.parseFloat(editText6.getText().toString());
            Cp1 = Float.parseFloat(editText7.getText().toString());
            betta1 = Float.parseFloat(editText8.getText().toString());
            gamma1 = Float.parseFloat(editText9.getText().toString());
            v1 = Float.parseFloat(editText10.getText().toString());
            GrPr1 = Float.parseFloat(editText11.getText().toString());
            Nu1 = Float.parseFloat(editText12.getText().toString());
            alfa1 = Float.parseFloat(editText13.getText().toString());
            Q1 = Float.parseFloat(editText14.getText().toString());

            Tcp = (Tct + Tv) / 2;
            p = (343829.713 * Math.pow((Tcp), -1.001)) / 1000;
            Cp = 0.1288 * Tcp + 975.0678;
            betta = (97493.7832 * Math.pow((Tcp), -0.9956)) / Math.pow((10), 5);
            gamma = (3.273 * Math.pow((Tcp), 0.7644)) / 10000;
            v = (0.0007 * Math.pow((Tcp), 2) + 0.654 * Tcp - 92.8731) / Math.pow((10), 7);

            if (Tcp < 574) {
                Pr = 0.71;
            } else {
                if (574 < Tcp && Tcp < 764) {
                    Pr = 0.72;
                } else {
                    if (Tcp > 764) {
                        Pr = 0.74;
                    }
                }
            }
            GrPr = (Pr * 9.8 * Math.pow((D), 3) * betta * (Tct - Tv)) / Math.pow((v), 2);
            if (GrPr < Math.pow((10), 4)) {
                n = 0.25;
                C = 0.53;
            } else {
                if (Math.pow((10), 4) < GrPr && GrPr < Math.pow((10), 9)) {
                    n = 0.25;
                    C = 0.53;
                } else {
                    if (GrPr > Math.pow((10), 9)) {
                        n = 1 / 3;
                        C = 0.13;
                    }
                }
            }
            Nu = C * Math.pow((GrPr), n);
            alfa = Nu * gamma / D;
            Q = alfa * L * D * 3.14 * (Tct - Tv);

            editText5.setText(String.valueOf(Tcp));
            editText6.setText(String.valueOf(p));
            editText7.setText(String.valueOf(Cp));
            editText8.setText(String.valueOf(betta));
            editText9.setText(String.valueOf(gamma));
            editText10.setText(String.valueOf(v));
            editText11.setText(String.valueOf(GrPr));
            editText12.setText(String.valueOf(Nu));
            editText13.setText(String.valueOf(alfa));
            editText14.setText(String.valueOf(Q));

            if (Tcp > Tcp1 * 0.95 && Tcp < Tcp1 * 1.05) {
                //editText5.setText(String.valueOf(Tcp1));
                editText5.setTextColor(Color.GREEN);
            } else {
                editText5.setTextColor(Color.RED);
            }
            if (p > p1 * 0.95 && p < p1 * 1.05) {
                //editText6.setText(String.valueOf(p1));
                editText6.setTextColor(Color.GREEN);
            } else {
                editText6.setTextColor(Color.RED);
            }
            if (Cp > Cp1 * 0.95 && Cp < Cp1 * 1.05) {
                //editText7.setText(String.valueOf(Cp1));
                editText7.setTextColor(Color.GREEN);
            } else {
                editText7.setTextColor(Color.RED);
            }
            if (betta > betta1 * 0.95 && betta < betta1 * 1.05) {
                //editText8.setText(String.valueOf(betta1));
                editText8.setTextColor(Color.GREEN);
            } else {
                editText8.setTextColor(Color.RED);
            }
            if (gamma > gamma1 * 0.95 && gamma < gamma1 * 1.05) {
                //editText9.setText(String.valueOf(gamma1));
                editText9.setTextColor(Color.GREEN);
            } else {
                editText9.setTextColor(Color.RED);
            }
            if (v > v1 * 0.95 && v < v1 * 1.05) {
                //editText10.setText(String.valueOf(v1));
                editText10.setTextColor(Color.GREEN);
            } else {
                editText10.setTextColor(Color.RED);
            }
            if (GrPr > GrPr1 * 0.95 && GrPr < GrPr1 * 1.05) {
                //editText11.setText(String.valueOf(GrPr1));
                editText11.setTextColor(Color.GREEN);
            } else {
                editText11.setTextColor(Color.RED);
            }
            if (Nu > Nu1 * 0.95 && Nu < Nu1 * 1.05) {
                //editText12.setText(String.valueOf(Nu1));
                editText12.setTextColor(Color.GREEN);
            } else {
                editText12.setTextColor(Color.RED);
            }
            if (alfa > alfa1 * 0.95 && alfa < alfa1 * 1.05) {
                //editText13.setText(String.valueOf(alfa1));
                editText13.setTextColor(Color.GREEN);
            } else {
                editText13.setTextColor(Color.RED);
            }
            if (Q > Q1 * 0.95 && Q < Q1 * 1.05) {
                //editText14.setText(String.valueOf(Q1));
                editText14.setTextColor(Color.GREEN);
            } else {
                editText14.setTextColor(Color.RED);
            }
        } catch (Exception e) {
            Toast toast = Toast.makeText(Main22Activity.this, "не все поля заполнены", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    private void coxranenue() {//сохраняем данные
        Tct2 = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed1 = Tct2.edit();
        ed1.putString(SAVED_TEXT, editText1.getText().toString());
        ed1.commit();
        Tv2 = getSharedPreferences("MyPref1", MODE_PRIVATE);
        SharedPreferences.Editor ed2 = Tv2.edit();
        ed2.putString(SAVED_TEXT, editText2.getText().toString());
        ed2.commit();
        D2 = getSharedPreferences("MyPref3", MODE_PRIVATE);
        SharedPreferences.Editor ed3 = D2.edit();
        ed3.putString(SAVED_TEXT, editText3.getText().toString());
        ed3.commit();
        L2 = getSharedPreferences("MyPref4", MODE_PRIVATE);
        SharedPreferences.Editor ed4 = L2.edit();
        ed4.putString(SAVED_TEXT, editText4.getText().toString());
        ed4.commit();
        Tcp2 = getSharedPreferences("MyPref5", MODE_PRIVATE);
        SharedPreferences.Editor ed5 = Tcp2.edit();
        ed5.putString(SAVED_TEXT, editText5.getText().toString());
        ed5.commit();
        p2 = getSharedPreferences("MyPref6", MODE_PRIVATE);
        SharedPreferences.Editor ed6 = p2.edit();
        ed6.putString(SAVED_TEXT, editText6.getText().toString());
        ed6.commit();
        Cp2 = getSharedPreferences("MyPref7", MODE_PRIVATE);
        SharedPreferences.Editor ed7 = Cp2.edit();
        ed7.putString(SAVED_TEXT, editText7.getText().toString());
        ed7.commit();
        betta2 = getSharedPreferences("MyPref8", MODE_PRIVATE);
        SharedPreferences.Editor ed8 = betta2.edit();
        ed8.putString(SAVED_TEXT, editText8.getText().toString());
        ed8.commit();
        gamma2 = getSharedPreferences("MyPref9", MODE_PRIVATE);
        SharedPreferences.Editor ed9 = gamma2.edit();
        ed9.putString(SAVED_TEXT, editText9.getText().toString());
        ed9.commit();
        v2 = getSharedPreferences("MyPref10", MODE_PRIVATE);
        SharedPreferences.Editor ed10 = v2.edit();
        ed10.putString(SAVED_TEXT, editText10.getText().toString());
        ed10.commit();
        GrPr2 = getSharedPreferences("MyPref11", MODE_PRIVATE);
        SharedPreferences.Editor ed11 = GrPr2.edit();
        ed11.putString(SAVED_TEXT, editText11.getText().toString());
        ed11.commit();
        Nu2 = getSharedPreferences("MyPref12", MODE_PRIVATE);
        SharedPreferences.Editor ed12 = Nu2.edit();
        ed12.putString(SAVED_TEXT, editText12.getText().toString());
        ed12.commit();
        alfa2 = getSharedPreferences("MyPref13", MODE_PRIVATE);
        SharedPreferences.Editor ed13 = alfa2.edit();
        ed13.putString(SAVED_TEXT, editText13.getText().toString());
        ed13.commit();
        Q2 = getSharedPreferences("MyPref14", MODE_PRIVATE);
        SharedPreferences.Editor ed14 = Q2.edit();
        ed14.putString(SAVED_TEXT, editText14.getText().toString());
        ed14.commit();
    }

    private void vuvod() {//достаем данные с памяти и отображаем их
        Tct2 = getSharedPreferences("MyPref", MODE_PRIVATE);
        String savedText = Tct2.getString(SAVED_TEXT, "");
        editText1.setText(savedText);
        Tv2 = getSharedPreferences("MyPref1", MODE_PRIVATE);
        String savedText2 = Tv2.getString(SAVED_TEXT, "");
        editText2.setText(savedText2);
        D2 = getSharedPreferences("MyPref3", MODE_PRIVATE);
        String savedText3 = D2.getString(SAVED_TEXT, "");
        editText3.setText(savedText3);
        L2 = getSharedPreferences("MyPref4", MODE_PRIVATE);
        String savedText4 = L2.getString(SAVED_TEXT, "");
        editText4.setText(savedText4);
        Tcp2 = getSharedPreferences("MyPref5", MODE_PRIVATE);
        String savedText5 = Tcp2.getString(SAVED_TEXT, "");
        editText5.setText(savedText5);
        p2 = getSharedPreferences("MyPref6", MODE_PRIVATE);
        String savedText6 = p2.getString(SAVED_TEXT, "");
        editText6.setText(savedText6);
        Cp2 = getSharedPreferences("MyPref7", MODE_PRIVATE);
        String savedText7 = Cp2.getString(SAVED_TEXT, "");
        editText7.setText(savedText7);
        betta2 = getSharedPreferences("MyPref8", MODE_PRIVATE);
        String savedText8 = betta2.getString(SAVED_TEXT, "");
        editText8.setText(savedText8);
        gamma2 = getSharedPreferences("MyPref9", MODE_PRIVATE);
        String savedText9 = gamma2.getString(SAVED_TEXT, "");
        editText9.setText(savedText9);
        v2 = getSharedPreferences("MyPref10", MODE_PRIVATE);
        String savedText10 = v2.getString(SAVED_TEXT, "");
        editText10.setText(savedText10);
        GrPr2 = getSharedPreferences("MyPref11", MODE_PRIVATE);
        String savedText11 = GrPr2.getString(SAVED_TEXT, "");
        editText11.setText(savedText11);
        Nu2 = getSharedPreferences("MyPref12", MODE_PRIVATE);
        String savedText12 = Nu2.getString(SAVED_TEXT, "");
        editText12.setText(savedText12);
        alfa2 = getSharedPreferences("MyPref13", MODE_PRIVATE);
        String savedText13 = alfa2.getString(SAVED_TEXT, "");
        editText13.setText(savedText13);
        Q2 = getSharedPreferences("MyPref14", MODE_PRIVATE);
        String savedText14 = Q2.getString(SAVED_TEXT, "");
        editText14.setText(savedText14);
    }
}
