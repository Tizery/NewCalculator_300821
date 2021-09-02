package com.example.newcalculator.domain;

public class CalculatorImpl implements Calculator{

    @Override
    public double performOperation(double argOne, double argTwo, Operation operation) {
        switch (operation) {

            case DIV:
                return argOne / argTwo;

            case MUL:
                return argOne * argTwo;

            case SUB:
                return argOne - argTwo;

            case ADD:
                return argOne + argTwo;

        }
        return 0;
    }

}
