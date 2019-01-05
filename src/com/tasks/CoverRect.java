package com.tasks;

public class CoverRect {
    public static void main(String[] args) {
        int answer = RectCover(18);
        System.out.println(answer);
    }

    private static int RectCover(int target) {

        if(target==0){
            return 0;
        }

        if (target==1) {
            return 1;
        }

        if (target==2) {
            return 2;
        }

        return RectCover(target - 1) + RectCover(target - 2);

    }
}
