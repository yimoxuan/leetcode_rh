package com.leetcode.learning.rh;

/**
 * 546. 移除盒子
 * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 *
 * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k * k 个积分。
 *
 * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
 */
public class Quest546_N {

    class Solution {
        int[][][] dp;

        public int removeBoxes(int[] boxes) {
            int length = boxes.length;
            dp = new int[length][length][length];
            return calculatePoints(boxes, 0, length - 1, 0);
        }

        public int calculatePoints(int[] boxes, int l, int r, int k) {
            if (l > r) {
                return 0;
            }
            if (dp[l][r][k] == 0) {
                dp[l][r][k] = calculatePoints(boxes, l, r - 1, 0) + (k + 1) * (k + 1);
                for (int i = l; i < r; i++) {
                    if (boxes[i] == boxes[r]) {
                        dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, l, i, k + 1) + calculatePoints(boxes, i + 1, r - 1, 0));
                    }
                }
            }
            return dp[l][r][k];
        }
    }


}
