package com.leetcode.learning.rh.leetcode;

import java.util.Arrays;

public class Quest561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0; i<nums.length; i++)
            if (i % 2==0)
                res += nums[i];
        return res;
    }
}
