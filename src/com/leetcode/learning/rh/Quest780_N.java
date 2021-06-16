package com.leetcode.learning.rh;

/**
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
 *
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest780_N {
    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            while (tx >= sx && ty >= sy) {
                if (tx == ty) break;
                if (tx > ty) {
                    if (ty > sy) tx %= ty;
                    else return (tx - sx) % ty == 0;
                } else {
                    if (tx > sx) ty %= tx;
                    else return (ty - sy) % tx == 0;
                }
            }
            return (tx == sx && ty == sy);
        }
    }
}
