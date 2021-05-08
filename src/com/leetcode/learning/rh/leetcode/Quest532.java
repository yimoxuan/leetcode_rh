package com.leetcode.learning.rh.leetcode;

import java.util.HashMap;
/**
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 *
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quest532 {
    class Solution {
        public int findPairs(int[] nums, int k) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int num : nums)
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            int count = 0;
            for (int num : hashMap.keySet()) {
                if (k == 0) {
                    if (hashMap.get(num) > 1)
                        count += 1;
                }
                else{
                    if (hashMap.keySet().contains(num + k))
                        count += 1;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest532().new Solution();
        System.out.println(solution.findPairs(new int[] {3,1,4,1,5}, 0));
    }
}
