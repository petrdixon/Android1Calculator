package com.geek.android1calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    private SettingsForTransferData settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // получить данные из Intent
        SettingsForTransferData settings = getIntent().getExtras().getParcelable("keyIntent");
        int themeStatusInSecond = settings.getThemeStatus();
        if (themeStatusInSecond == 1) {
            themeStatusInSecond = 2;
        } else themeStatusInSecond = 1;;

        // передаю новый int темы в main, сохраняя в SharedPreferences. В этои нет нужды для передачи только одного параметра,
        // но приходится чтобы не сломалась логика приложения. В предыдущих уроках требовалось использовать SharedPreferences
        Intent runMainActivity = new Intent(SecondActivity.this, MainActivity.class);
        SharedPreferences sharedPref = getSharedPreferences("anyName", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("key1", themeStatusInSecond);
        editor.apply();
        startActivity(runMainActivity);



    }


}