package com.leetcode.learning.rh.leetcode.dp;

import java.util.Arrays;

/**
 * 给你一个 互不相同 的整数数组，其中 locations[i] 表示第 i 个城市的位置。同时给你 start，finish 和 fuel 分别表示出发城市、目的地城市和你初始拥有的汽油总量
 * <p>
 * 每一步中，如果你在城市 i ，你可以选择任意一个城市 j ，满足  j != i 且 0 <= j < locations.length ，并移动到城市 j 。从城市 i 移动到 j 消耗的汽油量为 |locations[i] - locations[j]|，|x| 表示 x 的绝对值。
 * <p>
 * 请注意， fuel 任何时刻都 不能 为负，且你 可以 经过任意城市超过一次（包括 start 和 finish ）。
 * <p>
 * 请你返回从 start 到 finish 所有可能路径的数目。
 * <p>
 * 由于答案可能很大， 请将它对 10^9 + 7 取余后返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-all-possible-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest1575_N {
    class Solution {
        static final int MOD = 1000000007;
        int[][] f;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            f = new int[locations.length][fuel + 1];
            for (int[] row : f) {
                Arrays.fill(row, -1);
            }
            return dfs(locations, start, finish, fuel);
        }

        public int dfs(int[] locations, int pos, int finish, int rest) {
            if (f[pos][rest] != -1) {
                return f[pos][rest];
            }

            f[pos][rest] = 0;
            if (Math.abs(locations[pos] - locations[finish]) > rest) {
                return 0;
            }

            int n = locations.length;
            for (int i = 0; i < n; ++i) {
                if (pos != i) {
                    int cost;
                    if ((cost = Math.abs(locations[pos] - locations[i])) <= rest) {
                        f[pos][rest] += dfs(locations, i, finish, rest - cost);
                        f[pos][rest] %= MOD;
                    }
                }
            }
            if (pos == finish) {
                f[pos][rest] += 1;
                f[pos][rest] %= MOD;
            }
            return f[pos][rest];
        }
    }

}
