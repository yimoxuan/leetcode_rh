package com.leetcode.learning.rh.usemap;

/**
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 *
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 *
 * 子数组 定义为原数组中连续的一组元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/make-sum-divisible-by-p
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quest1590_N {
    /**
     * class Solution:
     *     def minSubarray(self, nums: List[int], p: int) -> int:
     *         map_dict = {0: -1}
     *         list_sum = 0
     *         all_sum = sum(nums)
     *         mod = all_sum % p
     *         if mod == 0:
     *             return 0
     *         min_res = len(nums)
     *         for index in range(len(nums)):
     *             list_sum += nums[index]
     *             # cur_mod - begin_mode % P = mod
     *             cur_mod = list_sum % p
     *             if cur_mod < mod and cur_mod - mod + p in map_dict.keys():
     *                 if index - map_dict[cur_mod - mod + p] < min_res:
     *                     min_res = index - map_dict[cur_mod - mod + p]
     *             elif cur_mod >= mod and cur_mod - mod in map_dict.keys():
     *                 if index - map_dict[cur_mod - mod] < min_res:
     *                     min_res = index - map_dict[cur_mod - mod]
     *             map_dict[cur_mod] = index
     *         if min_res == len(nums):
     *             return -1
     *         return min_res
     */
}
