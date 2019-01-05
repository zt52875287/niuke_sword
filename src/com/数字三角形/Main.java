package com.数字三角形;



import java.util.Scanner;

/**
 * 自顶向下 递归求解,使用二维数组存储已求解过的节点,减少计算量.
 *
 */
public class Main {
    /**
     * 5
     * ---------
     * 7
     * 3 8
     * 8 1 0
     * 2 7 4 4
     * 4 6 2 6 5
     * ---------
     * f(m,n) = max ( f(m+1,n) , f(m+1,n+1) )
     */

    public void test() {
        int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(getMaxPath(arr));
    }


    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] nums = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            System.out.println(getMaxPath(nums));
        }


    }


    public static int getMaxPath(int[][] source) {

        int len = source.length;
        int[][] sum = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <=i; j++) {
                sum[i][j] = -1;
            }
        }

        return cal(source, 0, 0, sum);

    }

    public static int cal(int[][] source, int m, int n, int[][] sum) {
        if (sum[m][n] != -1) return sum[m][n];

        if (m == source.length - 1) {
            sum[m][n] = source[m][n];
        } else {
            sum[m][n] = source[m][n] + Math.max(cal(source, m + 1, n, sum), cal(source, m + 1, n + 1, sum));
        }


        return sum[m][n];
    }

}
