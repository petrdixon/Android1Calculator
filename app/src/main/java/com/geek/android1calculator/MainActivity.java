package com.geek.android1calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int themeStatus = 0; // маяк смены темы. 0 - приложение запущено в 1 раз, дневная тема. 1 - дневная. 2 - ночная.
    private SettingsForTransferData settings;
    private int themeStatusFromSecond;

    public void setThemeStatus(int themeStatus) {
        this.themeStatus = themeStatus;
    }

    public int getThemeStatus() {
        return themeStatus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = new SettingsForTransferData();

        // получить данные из SecondActivity
        try {
            themeStatusFromSecond = getIntent().getExtras().getInt("anyKey");
            setThemeStatus(themeStatusFromSecond);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        setTheme(getTheme(getThemeStatus()));
        if (getThemeStatus() == 0) setThemeStatus(1);

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

        // Кнопка смены темы с помощью SharedPreferences
        Button buttonChangeTheme = findViewById(R.id.button_changeTheme);
        buttonChangeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getThemeStatus() == 1) {
                    setThemeStatus(2);
                } else setThemeStatus(1);

                // сохраним настройки/данные
                SharedPreferences sharedPref = getSharedPreferences("anyName", MODE_PRIVATE);
                // Настройки сохраняются посредством специального класса editor.
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", getThemeStatus());
                editor.apply();
                recreate(); // пересоздадим активити, чтобы тема применилась
            }
        });

        // Кнопка перехода во вторую активити для смены темы с помощью Intent и Parcelable
        // передаю только один параметр, можно было бы обойтись без файла Settings, но в уроке задание его использовать
        Button buttonTo2Activity = findViewById(R.id.button_toNextActivity);
        buttonTo2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settings.setThemeStatus(getThemeStatus());
                Intent runSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                runSecondActivity.putExtra("keyIntent", settings);  // Передача данных через интент
                startActivity(runSecondActivity);  // Метод стартует активити, указанную в интенте
            }
        });
    }

    // Сохранение формулы на экране при смене ориентации экрана

    private final static String orientation = "Orientation";
    ForChangeScreenOrientation changeScreenOrient = new ForChangeScreenOrientation();

    // Сохранение данных
    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        TextView textViewFormula = findViewById(R.id.textViewFormula);
        changeScreenOrient.setFormulaText(textViewFormula.getText());
        instanceState.putSerializable(orientation, changeScreenOrient);
    }

    // Восстановление данных
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        changeScreenOrient = (ForChangeScreenOrientation) instanceState.getSerializable(orientation);
        TextView textViewFormula = findViewById(R.id.textViewFormula);
        textViewFormula.setText(changeScreenOrient.getFormulaText());
    }


    public int getTheme(int x) {  // почему-то int, возвращаемый из метода, подчеркивается красным, если в метод не передать int. Я не понял почему. "int x" здесь просто заглушка
        SharedPreferences sharedPref = getSharedPreferences("anyName", MODE_PRIVATE); // Работаем через специальный класс сохранения и чтения настроек
        setThemeStatus(sharedPref.getInt("key1", 22)); // вызвать его метод getString, getInt и т. д. Первый параметр — ключ. Второй — значение по умолчанию
        switch (getThemeStatus()) {
            case 0:
                return R.style.AppThemeLight;
            case 1:
                return R.style.AppThemeLight;
            case 2:
                return R.style.AppThemeDark;
        }
        return 22;
    }

}

