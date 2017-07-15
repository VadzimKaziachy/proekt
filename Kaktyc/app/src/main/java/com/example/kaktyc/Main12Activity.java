package com.example.kaktyc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Main12Activity extends AppCompatActivity {
    EditText editText1, editText2, editText3, editText4, editText5, editText8, editText9, editText10,
            editText11,  editText12, editText13, editText14, editText15, editText16, editText17;

    Button button1, button2, button3;
    ImageView imageView1, imageView2, imageView3;

    final String SAVED_TEXT = "saved_text";
    SharedPreferences Tg2, Tm2, B2, h2, I2, a2, q2, w2, Eg2, Epr2, Eco22, Eh2o2, betta2, CO2, H2O;

    double Tg, Tm, B, h, I, a, q, w, Eg, Epr, Eco2, Eh2o, betta, a1, q1, w1, Eg1, Epr1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        initViews();
        pekaco();
        vuvod();
        setClickListeners();
    }
    private void initViews() {
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText11 = (EditText) findViewById(R.id.editText11);
        editText12 = (EditText) findViewById(R.id.editText12);
        editText13 = (EditText) findViewById(R.id.editText13);
        editText14 = (EditText) findViewById(R.id.editText14);
        editText15 = (EditText) findViewById(R.id.editText15);
        editText16 = (EditText) findViewById(R.id.editText16);
        editText17 = (EditText) findViewById(R.id.editText17);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
    }
    private  void pekaco(){//подключаем библиотеку  Picasso и открывыем кратинку с загрузкой
        Picasso.with (this)
                .load(R.drawable.twor)//оснавная картинка 
                .placeholder(R.drawable.spinner_ring)//загруска появляющая перед основной картинкой
                .into(imageView1);
        Picasso.with(this)
                .load(R.drawable.nnn)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView2);
        Picasso.with(this)
                .load(R.drawable.owor)
                .placeholder(R.drawable.spinner_ring)
                .into(imageView3);
    }


    private void setClickListeners() {//нажимаем на кнопку
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button1:
                        coxranenue();
                        Intent intent = new Intent(Main12Activity.this, Main1Activity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.nazat,0);
                        break;
                    case R.id.button2:
                        ranbom();
                        break;
                    case R.id.button3:
                        raschet();
                        break;
                }
            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
    }

    private void ranbom() {//рандомно выдаем числа в диопозоне
        editText1.setText(String.valueOf(1100 + (int) (Math.random() * ((1600 - 1100) + 1))));
        editText2.setText(String.valueOf(800 + (int) (Math.random() * ((1000 - 800) + 1))));
        editText3.setText(String.valueOf(1 + (int) (Math.random() * ((3 - 1) + 1))));
        editText4.setText(String.valueOf(3 + (int) (Math.random() * ((4 - 3) + 1))));
        editText5.setText(String.valueOf(1 + (int) (Math.random() * ((8 - 1) + 1))));
        editText8.setText(String.valueOf(10 + (int) (Math.random() * ((13 - 10) + 1))));
        editText9.setText(String.valueOf(4 + (int) (Math.random() * ((9 - 4) + 1))));
        editText10.setText(String.valueOf(0));
        editText11.setText(String.valueOf(0));
        editText12.setText(String.valueOf(0));
        editText13.setText(String.valueOf(0));
        editText14.setText(String.valueOf(0));
        editText15.setText(String.valueOf(0));
        editText16.setText(String.valueOf(0));
        editText17.setText(String.valueOf(0));
    }

    private void raschet() {
        try {
            Tg = Float.parseFloat(editText1.getText().toString());
            Tm = Float.parseFloat(editText2.getText().toString());
            B = Float.parseFloat(editText3.getText().toString());
            h = Float.parseFloat(editText4.getText().toString());
            I = Float.parseFloat(editText5.getText().toString());
            a1 = Float.parseFloat(editText10.getText().toString());
            q1 = Float.parseFloat(editText11.getText().toString());
            w1 = Float.parseFloat(editText12.getText().toString());
            Eg1 = Float.parseFloat(editText13.getText().toString());
            Epr1 = Float.parseFloat(editText14.getText().toString());
            Eco2 = Float.parseFloat(editText15.getText().toString());
            Eh2o = Float.parseFloat(editText16.getText().toString());
            betta = Float.parseFloat(editText17.getText().toString());

            w = (2 * h + B) / I;
            Eg = Eco2 + betta * Eh2o;
            Epr = (0.8 * (w + 1 - Eg) / (w + (0.8 + Eg * (1 - 0.8)) * (1 - Eg) / Eg));
            q = 5.67 * Epr * (Math.pow((Tg / 100), 4) - Math.pow((Tm / 100), 4));
            a = (5.67 * Epr * (Math.pow((Tg / 100), 4) - Math.pow((Tm / 100), 4))) / (Tg - Tm);

            editText15.setTextColor(Color.GREEN);
            editText16.setTextColor(Color.GREEN);
            editText17.setTextColor(Color.GREEN);

            if (q > q1 * 0.95 && q < q1 * 1.05) {
                editText11.setText(String.valueOf(q1));//записываем данные в ячейку
                editText11.setTextColor(Color.GREEN);//изменяем цвет ячейки
            } else {
                editText11.setTextColor(Color.RED);
            }
            if (a > a1 * 0.95 && a < a1 * 1.05){
                editText10.setText(String.valueOf(a1));
                editText10.setTextColor(Color.GREEN);
            } else {
                editText10.setTextColor(Color.RED);
            }
            if (w > w1 * 0.95 && w < w1 * 1.05){
                editText12.setText(String.valueOf(w1));
                editText12.setTextColor(Color.GREEN);
            } else {
                editText12.setTextColor(Color.RED);
            }
            if (Eg > Eg1 * 0.95 && Eg < Eg1 * 1.05){
                editText13.setText(String.valueOf(Eg1));
                editText13.setTextColor(Color.GREEN);
            } else {
                editText13.setTextColor(Color.RED);
            }
            if (Epr > Epr1 * 0.95 && Epr < Epr1 * 1.05){
                editText14.setText(String.valueOf(Epr1));
                editText14.setTextColor(Color.GREEN);
            } else {
                editText14.setTextColor(Color.RED);
            }
        }
        catch (Exception e){//делаем всплывающее окно
            Toast toast = Toast.makeText(Main12Activity.this, "не все поля заполнены", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

    }
    private void coxranenue(){//сохраняем данные
        Tg2 = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed1 = Tg2.edit();
        ed1.putString(SAVED_TEXT, editText1.getText().toString());
        ed1.commit();
        Tm2 = getSharedPreferences("MyPref1", MODE_PRIVATE);
        SharedPreferences.Editor ed2 = Tm2.edit();
        ed2.putString(SAVED_TEXT, editText2.getText().toString());
        ed2.commit();
        B2 = getSharedPreferences("MyPref3", MODE_PRIVATE);
        SharedPreferences.Editor ed3 = B2.edit();
        ed3.putString(SAVED_TEXT, editText3.getText().toString());
        ed3.commit();
        h2 = getSharedPreferences("MyPref4", MODE_PRIVATE);
        SharedPreferences.Editor ed4 = h2.edit();
        ed4.putString(SAVED_TEXT, editText4.getText().toString());
        ed4.commit();
        I2 = getSharedPreferences("MyPref5", MODE_PRIVATE);
        SharedPreferences.Editor ed5 = I2.edit();
        ed5.putString(SAVED_TEXT, editText5.getText().toString());
        ed5.commit();
        CO2 = getSharedPreferences("MyPref6", MODE_PRIVATE);
        SharedPreferences.Editor ed6 = CO2.edit();
        ed6.putString(SAVED_TEXT, editText8.getText().toString());
        ed6.commit();
        H2O = getSharedPreferences("MyPref7", MODE_PRIVATE);
        SharedPreferences.Editor ed7 = H2O.edit();
        ed7.putString(SAVED_TEXT, editText9.getText().toString());
        ed7.commit();
        a2 = getSharedPreferences("MyPref8", MODE_PRIVATE);
        SharedPreferences.Editor ed8 = a2.edit();
        ed8.putString(SAVED_TEXT, editText10.getText().toString());
        ed8.commit();
        q2 = getSharedPreferences("MyPref9", MODE_PRIVATE);
        SharedPreferences.Editor ed9 = q2.edit();
        ed9.putString(SAVED_TEXT, editText11.getText().toString());
        ed9.commit();
        w2 = getSharedPreferences("MyPref10", MODE_PRIVATE);
        SharedPreferences.Editor ed10 = w2.edit();
        ed10.putString(SAVED_TEXT, editText12.getText().toString());
        ed10.commit();
        Eg2 = getSharedPreferences("MyPref11", MODE_PRIVATE);
        SharedPreferences.Editor ed11 = Eg2.edit();
        ed11.putString(SAVED_TEXT, editText13.getText().toString());
        ed11.commit();
        Epr2 = getSharedPreferences("MyPref12", MODE_PRIVATE);
        SharedPreferences.Editor ed12 = Epr2.edit();
        ed12.putString(SAVED_TEXT, editText14.getText().toString());
        ed12.commit();
        Eco22 = getSharedPreferences("MyPref13", MODE_PRIVATE);
        SharedPreferences.Editor ed13 = Eco22.edit();
        ed13.putString(SAVED_TEXT, editText15.getText().toString());
        ed13.commit();
        Eh2o2 = getSharedPreferences("MyPref14", MODE_PRIVATE);
        SharedPreferences.Editor ed14 = Eh2o2.edit();
        ed14.putString(SAVED_TEXT, editText16.getText().toString());
        ed14.commit();
        betta2 = getSharedPreferences("MyPref15", MODE_PRIVATE);
        SharedPreferences.Editor ed15 = betta2.edit();
        ed15.putString(SAVED_TEXT, editText17.getText().toString());
        ed15.commit();
    }
    private void vuvod(){//достаем данные с памяти и отображаем их
        Tg2 = getSharedPreferences("MyPref", MODE_PRIVATE);
        String savedText = Tg2.getString(SAVED_TEXT, "");
        editText1.setText(savedText);
        Tm2 = getSharedPreferences("MyPref1", MODE_PRIVATE);
        String savedText2 = Tm2.getString(SAVED_TEXT, "");
        editText2.setText(savedText2);
        B2 = getSharedPreferences("MyPref3", MODE_PRIVATE);
        String savedText3 = B2.getString(SAVED_TEXT, "");
        editText3.setText(savedText3);
        h2 = getSharedPreferences("MyPref4", MODE_PRIVATE);
        String savedText4 = h2.getString(SAVED_TEXT, "");
        editText4.setText(savedText4);
        I2 = getSharedPreferences("MyPref5", MODE_PRIVATE);
        String savedText5 = I2.getString(SAVED_TEXT, "");
        editText5.setText(savedText5);
        CO2 = getSharedPreferences("MyPref6", MODE_PRIVATE);
        String savedText6 = CO2.getString(SAVED_TEXT, "");
        editText8.setText(savedText6);
        H2O = getSharedPreferences("MyPref7", MODE_PRIVATE);
        String savedText7 = H2O.getString(SAVED_TEXT, "");
        editText9.setText(savedText7);
        a2 = getSharedPreferences("MyPref8", MODE_PRIVATE);
        String savedText8 = a2.getString(SAVED_TEXT, "");
        editText10.setText(savedText8);
        q2 = getSharedPreferences("MyPref9", MODE_PRIVATE);
        String savedText9 = q2.getString(SAVED_TEXT, "");
        editText11.setText(savedText9);
        w2 = getSharedPreferences("MyPref10", MODE_PRIVATE);
        String savedText10 = w2.getString(SAVED_TEXT, "");
        editText12.setText(savedText10);
        Eg2 = getSharedPreferences("MyPref11", MODE_PRIVATE);
        String savedText11 = Eg2.getString(SAVED_TEXT, "");
        editText13.setText(savedText11);
        Epr2 = getSharedPreferences("MyPref12", MODE_PRIVATE);
        String savedText12 = Epr2.getString(SAVED_TEXT, "");
        editText14.setText(savedText12);
        Eco22 = getSharedPreferences("MyPref13", MODE_PRIVATE);
        String savedText13 = Eco22.getString(SAVED_TEXT, "");
        editText15.setText(savedText13);
        Eh2o2 = getSharedPreferences("MyPref14", MODE_PRIVATE);
        String savedText14 = Eh2o2.getString(SAVED_TEXT, "");
        editText16.setText(savedText14);
        betta2 = getSharedPreferences("MyPref15", MODE_PRIVATE);
        String savedText15 = betta2.getString(SAVED_TEXT, "");
        editText17.setText(savedText15);
    }

}
