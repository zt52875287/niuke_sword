package com.tasks;

public class Fib {

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }


    public static int Fibonacci(int n) {

        if(n==0){
            return 0;
        }

        if (n==1 || n==2) {
            return 1;
        }

        int n_1 = 1;
        int n_2 = 1;

        for (int i = 3; i <= n; i++) {
            int tmp = n_1;
            n_1 = n_1 + n_2;
            n_2 = tmp;
        }

        return n_1;
    }
}
