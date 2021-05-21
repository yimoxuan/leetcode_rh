package com.leetcode.learning.rh.dp;

import static java.lang.Math.max;

class Solution1 {
    public int maxSum(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int m = nums1.length;
        int n = nums2.length;
        long best1 = 0, best2 = 0;
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    best1 += nums1[i];
                    ++i;
                } else if (nums1[i] > nums2[j]) {
                    best2 += nums2[j];
                    ++j;
                } else {
                    long best = max(best1, best2) + nums1[i];
                    best1 = best2 = best;
                    ++i;
                    ++j;
                }
            } else if (i < m) {
                best1 += nums1[i];
                ++i;
            } else if (j < n) {
                best2 += nums2[j];
                ++j;
            }
        }
        return (int) (max(best1, best2) % MOD);
    }
}


public class Quest1537_N {
    private static int MOD = 1000000007;
    class Solution {
        public int maxSum(int[] nums1, int[] nums2) {
            long best1 = 0, best2 = 0;
            int index1 = 0, index2 = 0;
            while (index1 < nums1.length || index2 < nums2.length) {
                if (index1 < nums1.length && index2 < nums2.length && nums1[index1] == nums2[index2]) {
                    best1 = best2 = (max(best1, best2) + nums1[index1]) % MOD;
                    index1 += 1;
                    index2 += 1;
                    continue;
                }
                if (index1 < nums1.length && (index2 >= nums2.length || nums1[index1] < nums2[index2])) {
                    best1 = (best1 + nums1[index1++]) % MOD;
                    continue;
                }
                if (true) {
                    best2 = (best2 + nums2[index2++]) % MOD;
                    continue;
                }
            }
            return (int) max(best1, best2);
        }
    }

}
