package com.二维数组中的查找;

import java.util.ArrayList;
import java.util.List;
/*
题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。

 */
public class Dyadic_array_search {

    public static void main(String[] args) {

        List<String> aaa = new ArrayList();

        aaa.add("111");
        aaa.add("222");
        System.out.println(aaa.toString());

    }

    public static boolean Find(int target, int[][] array) {

        int x = array.length-1;
        int y = 0;

        System.out.println("初始化:" + x+ ","+y);

        while(x>=0 && y<array[0].length){

            System.out.println(x + "," +y + "=" + array[x][y]);

            if (array[x][y]<target) {
                y++;
            }else if (array[x][y]>target){
                x--;
            }else{
                return true;
            }
        }


        return false;

    }
}
