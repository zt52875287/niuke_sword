package com.矩阵中的路径;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/16
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class Solution {


    @Test
    public void testor() {
        char[] matrix = {'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        char[] str = {'S', 'E', 'E'};
        System.out.println(hasPath(matrix, 3, 4, str));

    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        int[] path = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0]) {
                if (trace(matrix, rows, cols, i / cols, i % cols, path, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean trace(char[] matrix, int rows, int cols, int startX, int startY, int[] path, char[] str, int strIndex) {

        int index = startX * cols + startY;
        if (startX >= rows || startX < 0 ||
                startY >= cols || startY < 0 ||
                path[index] == 1 ||
                matrix[index] != str[strIndex]) {
            return false;
        }

        if (strIndex == str.length - 1) {
            return true;
        }
        path[index] = 1;


        if (trace(matrix, rows, cols, startX + 1, startY, path, str, strIndex + 1) ||
                trace(matrix, rows, cols, startX, startY + 1, path, str, strIndex + 1) ||
                trace(matrix, rows, cols, startX - 1, startY, path, str, strIndex + 1) ||
                trace(matrix, rows, cols, startX, startY - 1, path, str, strIndex + 1)
                ) {
            return true;
        }

        path[index] = 0;
        return false;
    }


}


