package com.leetcode.learning.rh.leetcode;

public class Quest123 {

    class Solution {
        public int maxProfit(int[] prices) {
            int [] price_left = new int[prices.length];
            int [] price_right = new int[prices.length];
            int start_price = prices[0];
            for (int i = 1; i<prices.length; i++) {
                if (prices[i] >= start_price)
                    price_left[i] = prices[i] - start_price;
                else{
                    start_price = prices[i];
                }
            }
            start_price = prices[prices.length-1];
            for (int i= prices.length-2; i>=0; i--) {
                if (prices[i] < start_price)
                    price_right[i] = start_price - prices[i];
                else
                    start_price = prices[i];
                if (price_right[i] < price_right[i+1])
                    price_right[i] = price_right[i+1];
            }
            int res = 0;
            for (int i=0; i<prices.length; i++) {
                if (i != prices.length-1) {
                    int tmp = price_left[i] + price_right[i+1];
                    if (tmp > res) res = tmp;
                }
                else{
                    if (res < price_left[i])
                        res = price_left[i];
                }
            }

            return res;
        }

    }


    public static void main(String[] args) {
        Solution solution = new Quest123().new Solution();
        System.out.println(solution.maxProfit(new int [] {3,2,6,5,0,3}));
    }

}
