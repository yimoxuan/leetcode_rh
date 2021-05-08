package com.leetcode.learning.rh.leetcode.two_points;

public class square {

    private int getIndex(int [] nums) {
        /**
         * 第一个非负数
         */
        int begin = 0, end = nums.length-1;
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            // mid 肯定不是 0
            if (nums[mid] >= 0 && nums[mid-1] < 0)
                return mid;
            if (nums[mid] >= 0)
                end = mid - 1;
            else
                begin = mid + 1;
        }
        return begin;
    }

    public int[] sortedSquares(int[] nums) {
        int [] res = new int[nums.length];
        if (nums[0]>=0){
            for(int index=0; index<nums.length; index++)
                res[index] = nums[index] * nums[index];
            return res;
        }
        else{
            // 找到第一个正数位置
            int index = getIndex(nums);
            int index1 = index-1;
            int i = 0;
            while (index1 >= 0 || index < nums.length){
                if (index1 >= 0 && index < nums.length) {
                    if (nums[index1] * nums[index1] < nums[index] * nums[index]){
                        res[i] = nums[index1] * nums[index1];
                        index1 -= 1;
                    }
                    else{
                        res[i] = nums[index] * nums[index];
                        index += 1;
                    }
                }
                else{
                    if (index1 >= 0){
                        res[i] = nums[index1] * nums[index1];
                        index1 -= 1;
                    }
                    else{
                        res[i] = nums[index] * nums[index];
                        index += 1;
                    }
                }
                i += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        square two_points = new square();
        System.out.println(two_points.sortedSquares(new int[] {-4,-1,0,3,10}));
    }
}
