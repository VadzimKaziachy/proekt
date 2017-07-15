package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText, editText2, editText3;
    TextView textView, textView2;
    Button button, button3;
    int i, t, k;
    int[] mas;
    int[] sam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vvod();
        two();
    }
    public void vvod(){
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);
        button3 = (Button) findViewById(R.id.button3);
    }
    public void thy() {
        i = (int) Float.parseFloat(editText.getText().toString());      //вводим максимальное значение
        k = (int) Float.parseFloat(editText3.getText().toString());     //вводим минимальное значение
        mas = new int[i + 1];
        sam = new int[i + 1];
    }

    public void one(int[] mas, int[] sam, int k) {
        textView2.setText(String.valueOf(""));                           //обнуляем
        textView.setText(String.valueOf(""));                            //обнуляем

        mas[1] = (int) Float.parseFloat(editText2.getText().toString()); //записывает значение в массив
        for (t=0; t < mas.length; t++) {                               //записывает данные с одного массива в другой
            for (i = 0; i < sam.length; i++) {
                if (i == mas[t]) {                                       //если номер ячейки совпадает с числом записанным в массив, то тогда записываем его в новый массив
                    sam[i] = mas[t];                                     //число записанное в массив записываем в новый массив, при чем число соотвествует номеру ячейки
                }
            }
        }
        for (i = k; i < sam.length; i++) {
            if (sam[i] == 0) {                                        //смотрит, если в массиве есть нулевые элементы то тогда он выводит номер ячейки нулевого элемента
                textView2.append(String.valueOf(i + " "));
            }
            if (sam[i] != 0) {                                        //смотрит, если числов массиве не равно нулю, то тогла выводит это число
                textView.append(String.valueOf(sam[i] + " "));
            }
        }
        //textView.setText(Arrays.toString(sam));                     //обычная функция для сортеровки массива
        editText2.setText(String.valueOf(""));                        //удаляет число с поля ввода
    }
    private void two() {

            View.OnClickListener onClickListener = new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.button:
                            thy();
                            break;
                        case R.id.button3:
                            one(mas, sam, k);
                            break;
                    }
                }
            };
            button3.setOnClickListener(onClickListener);
            button.setOnClickListener(onClickListener);
    }
}

