package com.tasks;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Josephus_problem {


    public static void main(String[] args) {
        int n = 6;
        int m = 6;
        System.out.println(cal(n, m));



    }

    private static int cal(int n, int m) {

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int base = 0;

        while (list.size() > 1) {
            int del = (m + base - 1) % list.size();

            //System.out.println("删除了"+ list.get(del));
            list.remove(del);

            base = del ;

        }


        return list.get(0);
    }
}
