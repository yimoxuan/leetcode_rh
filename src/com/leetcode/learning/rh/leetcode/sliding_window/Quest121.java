package com.leetcode.learning.rh.leetcode.sliding_window;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class Quest121 {

    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length < 2)
            return 0;
        int min = prices[0];
        for (int price : prices) {
            res = res < price - min ? price - min:res;
            min = min < price ? min : price;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

