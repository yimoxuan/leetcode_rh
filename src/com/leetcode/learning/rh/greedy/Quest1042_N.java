package com.leetcode.learning.rh.greedy;

public class Quest1042_N {
    /**
     * class Solution:
     *     def gardenNoAdj(self, n: int, paths: List[List[int]]) -> List[int]:
     *         G = defaultdict(list)
     *         for u, v in paths:
     *             G[u].append(v)
     *             G[v].append(u)
     *         ans = [0] * n
     *         for u in range(1, n + 1):
     *             colors = set(range(1, 5)) - set(ans[v - 1] for v in G[u])
     *             ans[u - 1] = colors.pop()
     *         return ans
     */
}
