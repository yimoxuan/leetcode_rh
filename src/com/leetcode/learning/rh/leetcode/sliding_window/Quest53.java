package com.leetcode.learning.rh.leetcode.sliding_window;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 */

public class Quest53 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1};
        System.out.println(solution.maxSubArray(nums));
    }
}


class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums){
            if (sum < 0){
                sum = num;
            }
            else{
                sum += num;
            }
            res = sum > res?sum:res;
        }
        return res;
    }
}
