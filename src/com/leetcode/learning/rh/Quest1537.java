package com.leetcode.learning.rh;

import static java.lang.Math.max;

public class Quest1537 {
    class Solution {
        private final int MOD = 1000000007;
        public int maxSum(int[] nums1, int[] nums2) {
            long best1 = 0, best2 = 0;
            int index1 = 0, index2 = 0;
            while (index1 < nums1.length || index2 < nums2.length) {
                if (index1 < nums1.length && index2 < nums2.length && nums1[index1] == nums2[index2]) {
                    long best = (max(best1, best2) + nums1[index1]) % MOD;
                    best1 = best2 = best;
                    index1 += 1;
                    index2 += 1;
                    continue;
                }
                if (index1 < nums1.length && (index2 >= nums2.length || nums1[index1] < nums2[index2])) {
                    best1 = (best1 + nums1[index1++]) % MOD;
                    continue;
                }

                best2 = (best2 + nums2[index2++]) % MOD;

            }
            return (int) (max(best1, best2) % MOD);
        }
    }
}
