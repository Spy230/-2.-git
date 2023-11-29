package com.msaggik.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // создадим поля
    private float biscuit = 10;
    private int biscuitDiscount = 26;
    private float cream = 14;
    private int creamDiscount = 5;
    private float fruit = 3;
    private int fruitDiscount = 12;
    private float nuts = 5;
    private int nutsDiscount = 55;
    private float berries = 7;

    private float account = 45;

    private TextView possibilityOut;
    private TextView balanceOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);

        // запонение экрана
        if (possibility()) {
            possibilityOut.setText("Имеется достаточно средств для покупки ингредиентов для торта ");
            balanceOut.setText("Остаток от покупки " + balance() + " монет");
        } else {
            possibilityOut.setText("Недостаточно средств для покупки ингредиентов для торта ");
            balanceOut.setText(" - ");
        }
    }


    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (biscuit * (100 - biscuitDiscount) + cream * (100 - creamDiscount)
                + fruit * (100 - fruitDiscount) + nuts * (100 - nutsDiscount)
                + berries   / 100   * 3);
        return count;
    }


    private boolean possibility() {
        if (calculation() <= account) {
            return true;
        } else {
            return false;
        }
    }


    private float balance() {
        if(possibility()) {
            return account - calculation();
        } else { // иначе
            return -1;
        }
    }
}