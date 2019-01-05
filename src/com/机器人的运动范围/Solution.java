package com.机器人的运动范围;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/15
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution {
    @Test
    public void testor() {
        System.out.println(movingCount(5, 5, 5));
    }

    public int movingCount(int threshold, int rows, int cols) {
        int[][] resultMap = new int[rows][cols];
        return trace(threshold, resultMap, rows, cols, 0, 0);
    }

    private int trace(int threshold, int[][] resultMap, int rows, int cols, int x, int y) {

        if (x < 0 || x >= rows || y < 0 || y >= cols || cal(x) + cal(y) > threshold || resultMap[x][y] == 1) {
            return 0;
        }
        resultMap[x][y] = 1;
        return
                trace(threshold, resultMap, rows, cols, x, y + 1) +
                        trace(threshold, resultMap, rows, cols, x + 1, y) +
                        trace(threshold, resultMap, rows, cols, x - 1, y) +
                        trace(threshold, resultMap, rows, cols, x, y - 1) + 1;
    }

    private int cal(int x) {
        int s = 0;
        while (x % 10 != 0) {
            s = s + x % 10;
            x = x / 10;
        }
        return s;
    }


}
