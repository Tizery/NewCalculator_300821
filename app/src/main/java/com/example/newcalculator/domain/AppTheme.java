package com.example.newcalculator.domain;

import com.example.newcalculator.R;

public enum AppTheme {

    PINK(R.style.CalcTheme, "pink"),
    BLACK(R.style.CalcThemeBlack, "black");

    private final int theme;
    private final String key;

    AppTheme(int value, String key) {
        this.theme = value;
        this.key = key;
    }

    public int getTheme() {
        return theme;
    }

    public String getKey() {
        return key;
    }
}
