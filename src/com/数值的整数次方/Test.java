package com.数值的整数次方;

public class Test {
    public static void main(String[] args) {

    }

    public double Power(double base, int exponent) {
        double result =1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result = result *base;
        }
        return exponent<0? 1/result : result;
    }
}
