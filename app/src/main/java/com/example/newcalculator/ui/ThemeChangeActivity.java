package com.example.newcalculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.newcalculator.R;
import com.example.newcalculator.domain.AppTheme;
import com.example.newcalculator.storage.ThemeStorage;

public class ThemeChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeStorage storage = new ThemeStorage(this);

        setTheme(storage.getAppTheme().getTheme());

        setContentView(R.layout.activity_theme_change);

        findViewById(R.id.key_theme_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage.setAppTheme(AppTheme.PINK);
                recreate();
            }
        });

        findViewById(R.id.key_theme_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage.setAppTheme(AppTheme.BLACK);
                recreate();
            }
        });


    }

}
