package com.leetcode.learning.rh;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两个字符串 s 和 t ，请你通过若干次以下操作将字符串 s 转化成字符串 t ：
 * <p>
 * 选择 s 中一个 非空 子字符串并将它包含的字符就地 升序 排序。
 * 比方说，对下划线所示的子字符串进行操作可以由 "14234" 得到 "12344" 。
 * <p>
 * 如果可以将字符串 s 变成 t ，返回 true 。否则，返回 false 。
 * <p>
 * 一个 子字符串 定义为一个字符串中连续的若干字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-string-is-transformable-with-substring-sort-operations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest1585_N {
    class Solution {
        public boolean isTransformable(String s, String t) {
            int n = s.length();
            Queue<Integer>[] pos = new Queue[10];
            for (int i = 0; i < 10; ++i) {
                pos[i] = new LinkedList<>();
            }
            for (int i = 0; i < n; ++i) {
                pos[s.charAt(i) - '0'].offer(i);
            }
            for (int i = 0; i < n; ++i) {
                int digit = t.charAt(i) - '0';
                if (pos[digit].isEmpty()) {
                    return false;
                }
                for (int j = 0; j < digit; ++j) {
                    if (!pos[j].isEmpty() && pos[j].peek() < pos[digit].peek()) {
                        return false;
                    }
                }
                pos[digit].poll();
            }
            return true;
        }
    }
}
