package com.leetcode.learning.rh.leetcode.two_points;

public class Moven_Zeros {
    public void moveZeroes(int[] nums) {
        int index1 = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0){
                nums[index1] = nums[i];
                if (i != index1)
                    nums[i] = 0;
                index1 += 1;
            }
        }
    }
}
