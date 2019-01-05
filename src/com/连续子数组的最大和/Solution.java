package com.连续子数组的最大和;

import com.tasks.FindLastLinkNode;
import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 10, -4, 7, 2, -5};
        System.out.println(FindGreatestSumOfSubArray(arr));


    }

    /*
    以An为尾的最大子序列值:
    f(n) = max( f(n-1)+An , An )

    f(1) = A1
    f(2) = max( f(1)+A2 , A2 )
    f(3) = max( f(2)+A3 , A3 ) = max( max ( f(1)+A2+A3 , A2+A3 ) , A3 ) = max( A1+A2+A3 , A2+A3 , A3 )
    f(4) = max( f(3)+A4 , A4 ) = max( A1+A2+A3+A4 , A2+A3+A4 , A3+A4 , A4 )
    f(5) = max( f(4)+A4 , A4 ) = max( A1+A2+A3+A4+A5 , A2+A3+A4+A5 , A3+A4+A5 , A4+A5 , A5)
    ....
    f(n) = max( f(n-1)+An, An) = max( A1+...+An , A2+...+An , A3+...+An , ... , A(n-1)+An , An)

    可以看到,在求解f(1)~f(n)过程中,所有可能出现的子序列都参与了比较,我们只需要用int max 保存求解f(n)过程中的sum值即可.

    */
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = max;

        int left = 0;
        int right = 0;

        for (int i = 1; i < array.length; i++) {

            // f(n) = max( f(n-1)+An , An )
            if (sum + array[i] < array[i]) {  // 不等式两边都减去array[i],这一行可以等价为: sum<0   表示前面的和是负值,对总和是有害的,全部舍弃掉.                sum = array[i];
                sum = array[i];
                left = i;
            } else {
                sum += array[i];

            }

            if (max < sum) {
                max = sum;
                right = i;
            }
        }
        //最大区间的下标是left和right
        //System.out.println(left+","+right);
        return max;
    }
    /*

    换个角度理解上述递推:

    对于任何一个数组,从头开始遍历时,总能被划分为若干个这样的子串:
    Ai....Aj , Ak  , Al....Am , An , Ao...Ap , Aq
    AK\AM\AQ是一个的负值,而且它前面子串的和为正数,加上它之后,子串的和为负数:
    即:
        对于Ak: ai+......+aj    > 0
                ai+......+aj+ak < 0
        对于全正数的串,这样的区间的个数是1(即,长度是数组的长度)
        对于全负数的串,这样的区间的个数是数组的长度(即,每个区间长度是1)
    最终求得的最大和,必然是这样的一个子串:它以某一个区间的开头Ai,Al,Ao...为开头,以区间中间的某一点为结尾.

    */

    /*public int FindGreatestSumOfSubArray(int[] array) {
        int[] result = new int[array.length];
        int max =array[0];

        for (int span = 1; span <= array.length; span++) {
            for (int i = 0; i <= array.length - span; i++) {
                result[i] =  result[i] + array[span + i-1];
                if(result[i]>max) max = result[i];
            }
            //System.out.println(span + " - "+ Arrays.toString(result) + " - " + max);
        }
        return max;
    }*/
}
