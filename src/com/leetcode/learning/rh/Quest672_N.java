package com.leetcode.learning.rh;

/**
 * 现有一个房间，墙上挂有 n 只已经打开的灯泡和 4 个按钮。在进行了 m 次未知操作后，你需要返回这 n 只灯泡可能有多少种不同的状态。
 *
 * 假设这 n 只灯泡被编号为 [1, 2, 3 ..., n]，这 4 个按钮的功能如下：
 *
 * 将所有灯泡的状态反转（即开变为关，关变为开）
 * 将编号为偶数的灯泡的状态反转
 * 将编号为奇数的灯泡的状态反转
 * 将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulb-switcher-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest672_N {
    class Solution {
        public int flipLights(int n, int m) {
            n = Math.min(n, 3);
            if (m == 0) return 1;
            if (m == 1) return n == 1 ? 2 : n == 2 ? 3 : 4;
            if (m == 2) return n == 1 ? 2 : n == 2 ? 4 : 7;
            return n == 1 ? 2 : n == 2 ? 4 : 8;
        }
    }

}
