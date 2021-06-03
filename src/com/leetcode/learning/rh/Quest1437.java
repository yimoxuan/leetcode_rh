package com.leetcode.learning.rh;

public class Quest1437 {
    class Solution {
        private boolean kLengthApart(int[] nums, int k) {
            int index = 0;
            while (index < nums.length && nums[index] != 1)
                index++;
            int count;
            index++;
            while (index < nums.length) {
                count = 0;
                while(index < nums.length && nums[index]!=1) {
                    index += 1;
                    count += 1;
                }
                if (count < k && index < nums.length)
                    return false;
                index++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1437().new Solution();
        System.out.println(solution.kLengthApart(new int[] {1,0,0,0,1,0,0,1,0}, 2));
    }
}
