package com.leetcode.learning.rh.leetcode;

public class Quest1748 {
    class Solution {
        public int sumOfUnique(int[] nums) {
            int [] table = new int[101];
            for (int num : nums)
                table[num] += 1;

            for (int i=1; i<101; i++) {
                if (table[i] == 1)
                    table[0] += table[i];
            }
            return table[0];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1748().new Solution();
        System.out.println(solution.sumOfUnique(new int[] {1,2,3,2}));
    }
}
