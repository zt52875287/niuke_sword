package com.tasks;

import javax.xml.stream.events.EndDocument;

public class ArrayRotate {

    public static void main(String[] args) {

        int[] c = {6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717,
                9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293,
                334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392,
                2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142,
                5437, 5448, 5668, 5706, 5725, 6300, 6335};
        System.out.println(minNumberInRotateArray(c));
        int c1[] = {1,2,3,4,5,6};
        System.out.println(minNumberInRotateArray(c1));
        int c2[] = {7,8,1,2,3,4,5,6};
        System.out.println(minNumberInRotateArray(c2));
        int c3[] = {4,5,6,7,8,9,10,1,2,3};
        System.out.println(minNumberInRotateArray(c3));


    }

    public static int minNumberInRotateArray(int[] array) {


        int len = array.length;

        if (len <= 0) {
            return 0;
        }

        if (array[0]<array[array.length-1]){
            return  array[0];
        }

        int flag = array[0];

        int head = 0;
        int tail = len - 1;

        while (head <=tail) {
            int mid = (head + tail) / 2;

//            System.out.println("head " + head);
//            System.out.println("mid " + mid);
//            System.out.println("tail " + tail);
//            System.out.println("flag " + flag);
//            System.out.println("---------------------");
            if (array[mid] >= flag) {

                head = mid+1;

            } else {
                flag = array[mid];
                    tail = mid - 1;


            }
        }
        return flag;
    }
}
