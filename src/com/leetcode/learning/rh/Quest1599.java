package com.leetcode.learning.rh;

public class Quest1599 {

    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int leftNum = 0;
            int profit = 0;
            int maxProfit = 0;
            int leftTime = 0;
            for (int i=0; i<customers.length; i++) {
                if (maxProfit < profit)
                    maxProfit = profit;
                if (leftNum + customers[i] >= 4) {
                    profit += 4 * boardingCost - runningCost;
                    leftNum = leftNum + customers[i] - 4;
                    leftTime = 3;
                }
                else{
                    if (leftNum + customers[i] == 0)
                        leftTime -= 1;
                    else{
                        leftTime = 3;
                    }
                    profit += boardingCost * leftNum - runningCost;
                    leftNum = 0;
                }
            }
            while (leftNum > 0) {
                profit += leftNum > 4 ? 4 * boardingCost : leftNum * boardingCost - runningCost;
                leftNum = leftNum > 4 ? leftNum - 4 : 0;
                leftTime = 3;
            }
//            profit -= leftTime * runningCost;
            if (maxProfit < profit)
                maxProfit = profit;
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1599().new Solution();
        System.out.println(solution.minOperationsMaxProfit(
                new int [] {8, 3}, 5, 6
        ));
    }
}
