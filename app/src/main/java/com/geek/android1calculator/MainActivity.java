package com.geek.android1calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewFormula = findViewById(R.id.textViewFormula);
        TextView buttonC = findViewById(R.id.button_C);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button button0 = findViewById(R.id.button_0);
        Button button00 = findViewById(R.id.button_00);
        Button buttonEquals = findViewById(R.id.button_equal);
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonMultiply = findViewById(R.id.button_x);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("0");
            }
        });

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("00");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("+");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("-");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("÷");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("*");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.setText("");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewFormula.append("=");
                CharSequence inputtedFormula = textViewFormula.getText();

                Calculation calc = new Calculation(inputtedFormula.toString());
                calc.formulaCalculation();
                textViewFormula.setText("");
                textViewFormula.append(String.valueOf(calc.getPresentValueAfterCalculation()));
            }
        });


    }
}