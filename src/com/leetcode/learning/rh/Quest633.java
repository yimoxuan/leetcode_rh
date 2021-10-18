package com.leetcode.learning.rh;

public class Quest633 {
    class Solution {
        public boolean judgeSquareSum(int c) {
            for (int i=0; i<=Math.sqrt(c); i++) {
                int right = (int) Math.sqrt(c - i * i);
                if (right * right + i * i == c)
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest633().new Solution();
        System.out.println(solution.judgeSquareSum(4));
    }
}
