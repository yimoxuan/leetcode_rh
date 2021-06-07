package com.leetcode.learning.rh;

/**
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 *
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 *
 * 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest05_01 {
    class Solution {
        public int insertBits(int N, int M, int i, int j) {
            for (int k = i; k <= j; k++) {
                //1 << k  将1 左移k位
                //~(1 << k) 取反后 第k位为0，其他位为1
                //&= ~(1 << k)  & 运算后，k位肯定为0，1&1 才是1，其他情况都是0
                //这一步的操作相当于将[i,j]位全部置为0
                N &= ~(1 << k);
            }
            //加上M 移位后结果
            N += (M << i);
            return N;
        }

    }

}
