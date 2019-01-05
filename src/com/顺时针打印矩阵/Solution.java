package com.顺时针打印矩阵;

import org.junit.Before;
import org.junit.Test;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static java.lang.Double.NaN;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1  2   3  4  x
 * 5  6  7  8  x
 * 9  10 11 12 x
 * 13 14 15 16 x
 * 17 18 19 20 x
 * 则依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1, 2, 3, 4,},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}};
        int[][] ints1 = new int[][]{
                {1, 2, 3, 4}};
        int[][] ints2 = new int[][]{
                {1}, {2}, {3}, {4}};
        int[][] ints3 = new int[][]{
                {1, 2, 3, 4,},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        ArrayList<Integer> list = printMatrix(ints3);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        byte[] bytes = new byte[5];

        int[] ints4 = new int[5];
        Arrays.sort(ints4);

        double[] doubles = new double[5];
        doubles[0] = NaN;
        Arrays.sort(doubles);
        Student student = new Student();
        Student[] students = new Student[2];
        Arrays.sort(students);

        ArrayList<Student> stus = new ArrayList<>();
        stus.add(student);
        Collections.sort(stus);
    }



    static public ArrayList<Integer> printMatrix(int[][] matrix) {

        // 每行a个元素
        int a = matrix.length;
        // 每列b个元素
        int b = matrix[0].length;

        //找出较短的边
        int shortEdge = (a < b ? a : b);

        // 根据短边，计算出共有x层元素
        int layer = shortEdge % 2 == 1 ? (shortEdge + 1) / 2 : shortEdge / 2;

        //每层的长宽，逐层递减
        int layer_a = a;
        int layer_b = b;

        //存出结果
        ArrayList<Integer> result = new ArrayList<>();

        //逐层（转圈）打印,每层的起点为[layer,layer]
        for (int i = 0; i < layer; i++) {

            for (int j = i; j <= b - i - 1; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i + 1; j <= a - i - 1; j++) {
                result.add(matrix[j][b - i - 1]);
            }
            //当某一层元素元素只有一行或者一列，则不继续打印
            if (a-i*2>1 && b-i*2>1) {

                for (int j = b - i - 2; j >= i; j--) {
                    result.add(matrix[a - i - 1][j]);
                }
                for (int j = a - i - 2; j >= i + 1; j--) {
                    result.add(matrix[j][i]);
                }

            }
        }

        return result;
    }
}
class Student implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
