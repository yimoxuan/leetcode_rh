package com.leetcode.learning.rh.leetcode;

/**
 * 有 A 和 B 两种类型的汤。一开始每种类型的汤有 N 毫升。有四种分配操作：
 * <p>
 * 提供 100ml 的汤A 和 0ml 的汤B。
 * 提供 75ml 的汤A 和 25ml 的汤B。
 * 提供 50ml 的汤A 和 50ml 的汤B。
 * 提供 25ml 的汤A 和 75ml 的汤B。
 * 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为0.25的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
 * <p>
 * 注意不存在先分配100 ml汤B的操作。
 * <p>
 * 需要返回的值： 汤A先分配完的概率 + 汤A和汤B同时分配完的概率 / 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/soup-servings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest808_N {
    public static void main(String[] args) {
        Solution solution = new Quest808_N().new Solution();
        System.out.println(solution.soupServings(50));
    }

    class Solution {
        public double soupServings(int N) {
            N = N / 25 + (N % 25 > 0 ? 1 : 0);
            if (N >= 198) return 1.0;
            // 大于等于198的都优化掉
            double[][] memo = new double[N + 1][N + 1];
            for (int j = 0; j <= N; ++j) {
                for (int i = 0; i <= N; ++i) {
//                    int j = s-i;
                    if (j < 0 || j > N) continue;
                    double ans = 0.0;
                    if (i == 0) ans = 1.0;
                    if (i == 0 && j == 0) ans = 0.5;
                    if (i > 0 && j > 0) {
                        ans = 0.25 * (memo[M(i - 4)][j] + memo[M(i - 3)][M(j - 1)] +
                                memo[M(i - 2)][M(j - 2)] + memo[M(i - 1)][M(j - 3)]);
                    }
//                    System.out.println(i + " " + j);
                    memo[i][j] = ans;

                }
            }
            return memo[N][N];
        }

        public int M(int x) {
            return Math.max(0, x);
        }
    }

    class SolutionBest {
        double[][] cache;

        public double soupServings(int N) {
            if (N > 5000) {
                return 1;
            }
            int n = N / 25 + (N % 25 == 0 ? 0 : 1);
            cache = new double[n + 1][n + 1];
            return getP(n, n);
        }

        public double getP(int soupA, int soupB) {
            if (soupA <= 0 && soupB <= 0) {
                return 0.5;
            }
            if (soupA <= 0 && soupB > 0) {
                return 1;
            }
            if (soupB <= 0) {
                return 0;
            }
            if (cache[soupA][soupB] != 0) {
                return cache[soupA][soupB];
            }
            double result = 0.25 * (getP(soupA - 4, soupB) + getP(soupA - 3, soupB - 1) + getP(soupA - 2, soupB - 2) + getP(soupA - 1, soupB - 3));
            cache[soupA][soupB] = result;
            return result;
        }
    }
}
