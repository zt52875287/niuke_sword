package com.tasks;

public class CountBinary {
    public static void main(String[] args) {

        int n = -1;

        System.out.println(NumberOf1(n));
        System.out.println(NumberOf1_2(n));
    }


    public static int NumberOf1_2(int n) {
        int count = 0;
        int base = 1;

        while (base!=0) {

            if ((n&base)!=0) {
                count++;
            }

            base = base <<1;
        }
        return count;
    }
    public static int NumberOf1(int n) {

        return Integer.toBinaryString(n).replaceAll("0", "").length();

    }
}
