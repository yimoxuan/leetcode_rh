package com.leetcode.learning.rh;

import java.util.Arrays;

/**
 * 给你一个整数数组 A，对于每个整数 A[i]，可以选择 x = -K 或是 x = K （K 总是非负整数），并将 x 加到 A[i] 中。
 *
 * 在此过程之后，得到数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest910_N {
    class Solution {
        public int smallestRangeII(int[] A, int K) {
            int N = A.length;
            Arrays.sort(A);
            int ans = A[N-1] - A[0];
            for (int i = 0; i < A.length - 1; ++i) {
                int a = A[i], b = A[i+1];
                int high = Math.max(A[N-1] - K, a + K);
                int low = Math.min(A[0] + K, b - K);
                ans = Math.min(ans, high - low);
            }
            return ans;
        }
    }
}
