package com.example.newcalculator.ui;

import com.example.newcalculator.domain.Calculator;
import com.example.newcalculator.domain.Operation;

public class CalculatorPresenter {

    private static final int BASE = 10;

    private final CalculatorView view;

    private final Calculator calculator;

    private Double argOne = 0.0;
    private Double argTwo = null;

    private boolean isRealInput = false;
    private int realMultiplier = BASE;

    private Operation operation;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onKeyPressed(int value) {

        if (argTwo == null) {
            argOne = addDigit(argOne, value);
            view.showResult(String.valueOf(argOne));

        } else {
            argTwo = addDigit(argTwo, value);

            view.showResult(String.valueOf(argTwo));
        }
    }

    public void onKeyDivPressed() {
        performOperation(Operation.DIV);
    }

    public void onKeyMulPressed() {
        performOperation(Operation.MUL);
    }

    public void onKeySubPressed() {
        performOperation(Operation.SUB);
    }

    public void onKeyAddPressed() {
        performOperation(Operation.ADD);
    }

    public void onKeyDotPressed() {
        if (isRealInput) {
            return;
        }
        isRealInput = true;
        realMultiplier = BASE;
    }

    private void performOperation(Operation op) {
        if (argTwo == null) {
            operation = op;
            argTwo = 0.0;

        } else {
            double res = calculator.performOperation(argOne, argTwo, operation);
            view.showResult(String.valueOf(res));
            argOne = res;
            argTwo = 0.0;
            operation = op;
        }
        isRealInput = false;
    }

    private double addDigit(double arg, int digit) {
        if (!isRealInput) {
            return arg * BASE + digit;
        } else {
            double result = arg + digit / (double) realMultiplier;
            realMultiplier *= BASE;
            return result;
        }
    }

}
