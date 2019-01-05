package com.数字三角形;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Dp_solution {

    @Test
    public void test() {
        int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(getMaxPath2(arr));
    }

    /**
     * 自身存结果
     * @param source
     * @return
     */
    public static int getMaxPath2(int[][] source) {

        for (int i = source.length-2; i >= 0; i--) {

            for (int j = 0; j<=i; j++) {
                source[i][j] = source[i][j] + Math.max(source[i+1][j],source[i+1][j+1]);
            }
        }

        return source[0][0] ;
    }

    /**
     * 一维数组存结果
     * @param source
     * @return
     */

    public static int getMaxPath(int[][] source) {

        int[] result = new int[source.length];


        for (int i = source.length-1; i >= 0; i--) {

            for (int j = 0; j<=i; j++) {
                if (i == source.length - 1) {
                    result[j] = source[i][j];
                } else {
                    result[j] = source[i][j] + Math.max(result[j], result[j + 1]);
                }
            }
        }

        return result[0];
    }


}
