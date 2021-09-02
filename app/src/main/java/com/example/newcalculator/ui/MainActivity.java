package com.example.newcalculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.newcalculator.R;
import com.example.newcalculator.domain.CalculatorImpl;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    private CalculatorPresenter presenter;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);
        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        HashMap<Integer, Integer> digits = new HashMap<>();

        digits.put(R.id.key_0, 0);
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);

        View.OnClickListener digitsClicked = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyPressed(digits.get(v.getId()));
            }
        };

        findViewById(R.id.key_0).setOnClickListener(digitsClicked);
        findViewById(R.id.key_1).setOnClickListener(digitsClicked);
        findViewById(R.id.key_2).setOnClickListener(digitsClicked);
        findViewById(R.id.key_3).setOnClickListener(digitsClicked);
        findViewById(R.id.key_4).setOnClickListener(digitsClicked);
        findViewById(R.id.key_5).setOnClickListener(digitsClicked);
        findViewById(R.id.key_6).setOnClickListener(digitsClicked);
        findViewById(R.id.key_7).setOnClickListener(digitsClicked);
        findViewById(R.id.key_8).setOnClickListener(digitsClicked);
        findViewById(R.id.key_9).setOnClickListener(digitsClicked);

        findViewById(R.id.key_div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyDivPressed();
            }
        });

        findViewById(R.id.key_mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyMulPressed();
            }
        });

        findViewById(R.id.key_sub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeySubPressed();
            }
        });

        findViewById(R.id.key_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyAddPressed();
            }
        });

        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyDotPressed();
            }
        });
    }

    @Override
    public void showResult(String result) {
        resultTextView.setText(result);
    }
}