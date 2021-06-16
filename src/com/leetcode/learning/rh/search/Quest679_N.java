package com.leetcode.learning.rh.search;

/**
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 */

public class Quest679_N {
    /**
     * class Solution:
     *     def judgePoint24(self, nums: List[int]) -> bool:
     *         TARGET = 24
     *         EPSILON = 1e-6
     *         ADD, MULTIPLY, SUBTRACT, DIVIDE = 0, 1, 2, 3
     *
     *         def solve(nums: List[float]) -> bool:
     *             if not nums:
     *                 return False
     *             if len(nums) == 1:
     *                 return abs(nums[0] - TARGET) < EPSILON
     *             for i, x in enumerate(nums):
     *                 for j, y in enumerate(nums):
     *                     if i != j:
     *                         newNums = list()
     *                         for k, z in enumerate(nums):
     *                             if k != i and k != j:
     *                                 newNums.append(z)
     *                         for k in range(4):
     *                             if k < 2 and i > j:
     *                                 continue
     *                             if k == ADD:
     *                                 newNums.append(x + y)
     *                             elif k == MULTIPLY:
     *                                 newNums.append(x * y)
     *                             elif k == SUBTRACT:
     *                                 newNums.append(x - y)
     *                             elif k == DIVIDE:
     *                                 if abs(y) < EPSILON:
     *                                     continue
     *                                 newNums.append(x / y)
     *                             if solve(newNums):
     *                                 return True
     *                             newNums.pop()
     *             return False
     *
     *         return solve(nums)
     */
}
