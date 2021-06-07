package com.leetcode.learning.rh.dp;

import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个正整数 x，我们将会写出一个形如 x (op1) x (op2) x (op3) x ... 的表达式，其中每个运算符 op1，op2，… 可以是加、减、乘、除（+，-，*，或是 /）之一。例如，对于 x = 3，我们可以写出表达式 3 * 3 / 3 + 3 - 3，该式的值为 3 。
 *
 * 在写这样的表达式时，我们需要遵守下面的惯例：
 *
 * 除运算符（/）返回有理数。
 * 任何地方都没有括号。
 * 我们使用通常的操作顺序：乘法和除法发生在加法和减法之前。
 * 不允许使用一元否定运算符（-）。例如，“x - x” 是一个有效的表达式，因为它只使用减法，但是 “-x + x” 不是，因为它使用了否定运算符。 
 * 我们希望编写一个能使表达式等于给定的目标值 target 且运算符最少的表达式。返回所用运算符的最少数量。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/least-operators-to-express-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Quest964_N {
    class Solution {
        Map<String, Integer> memo;
        int x;
        public int leastOpsExpressTarget(int x, int target) {
            memo = new HashMap();
            this.x = x;
            return dp(0, target) - 1;
        }

        public int dp(int i, int target) {
            String code = "" + i + "#" + target;
            if (memo.containsKey(code))
                return memo.get(code);

            int ans;
            if (target == 0) {
                ans = 0;
            } else if (target == 1) {
                ans = cost(i);
            } else if (i >= 39) {
                ans = target + 1;
            } else {
                int t = target / x;
                int r = target % x;
                ans = Math.min(r * cost(i) + dp(i+1, t),
                        (x-r) * cost(i) + dp(i+1, t+1));
            }

            memo.put(code, ans);
            return ans;
        }

        public int cost(int x) {
            return x > 0 ? x : 2;
        }
    }
}
