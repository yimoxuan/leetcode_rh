package com.leetcode.learning.rh;

public class Quest991 {
    class Solution {
        public int brokenCalc(int X, int Y) {

            int count = 0;
            if(Y % 2 == 1)
                Y += 1;
            while (X != Y) {
                if (X * 2 == Y + 1) {
                    X = X * 2 - 1;
                    count += 2;
                } else {
                    if (X * 2 < Y + 1) {
                        X = 2 * X;
                        count += 1;
                    } else {
                        X = X - 1;
                        count += 1;
                    }
                }

            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest991().new Solution();
        System.out.println(solution.brokenCalc(1, 1000000000));
    }
}
