package com.leetcode.learning.rh.leetcode;

public class Quest1774_N {
    class Solution {
        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            boolean [] nums = new boolean[20001];
            for (int base: baseCosts)
                nums[base] = true;
            for (int topping : toppingCosts) {
                for (int i=20000; i >= topping; i--){
                    if (i >= 2*topping && nums[i-2*topping])
                        nums[i] = true;
                    nums[i] = nums[i] || nums[i-topping];
                }
            }

            int closest = 0x7fffffff;
            for (int i=0; i+ target <20001 || target-i>=0; i++){
                if(i + target < 20001 && nums[i+target])
                    return i+target;
                if (target - i>=0 && nums[target-i])
                    return i-target;
            }
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
