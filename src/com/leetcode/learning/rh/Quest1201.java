package com.leetcode.learning.rh;

import com.leetcode.learning.rh.leetcode.Quest930;

public class Quest1201 {
    class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            int index1 = 1, index2 = 1, index3 = 1;
            long min = 0;
            for (int i=0; i<n; i++) {
                long num1 = index1 * a;
                long num2 = index2 * b;
                long num3 = index3 * c;
                min = num1;
                if (min > num2)
                    min = num2;
                if (min > num3)
                    min = num3;
                if (min == num1)
                    index1 += 1;
                if (min == num2)
                    index2 += 1;
                if (min == num3)
                    index3 += 1;
//                System.out.println(i);
            }
            return (int)min;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1201().new Solution();
        System.out.println(solution.nthUglyNumber(1000000000,
                2,
                217983653,
                336916467));
    }
}
