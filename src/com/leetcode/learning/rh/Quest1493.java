package com.leetcode.learning.rh;

public class Quest1493 {
    class Solution {
        public int longestSubarray(int[] nums) {
            int maxLen = 0;
            int index = 0;
            int lastZero = 0;
            int tmpLen = 0;
            lastZero = -1;
            while(index < nums.length) {
                if (nums[index] == 0) {
                    // 删除当前元素的长度, 要删除当前元素
                    tmpLen = index - lastZero - 1;
                    lastZero = index;
                }
                else{
                    tmpLen += 1;
                }
                if (tmpLen > maxLen)
                    maxLen = tmpLen;
                index += 1;
            }
            if (maxLen == nums.length)
                return maxLen - 1;
            return maxLen;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1493().new Solution();
        System.out.println(solution.longestSubarray(new int [] {1, 1, 1}));
    }
}
