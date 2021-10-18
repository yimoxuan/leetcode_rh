package com.leetcode.learning.rh;

/**
 * 给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
 *
 * 如果所读的字符是字母，则将该字母写在磁带上。
 * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decoded-string-at-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest880_N {
    class Solution {
        public String decodeAtIndex(String S, int K) {
            long size = 0;
            int N = S.length();

            // Find size = length of decoded string
            for (int i = 0; i < N; ++i) {
                char c = S.charAt(i);
                if (Character.isDigit(c))
                    size *= c - '0';
                else
                    size++;
            }

            for (int i = N-1; i >= 0; --i) {
                char c = S.charAt(i);
                K %= size;
                if (K == 0 && Character.isLetter(c))
                    return Character.toString(c);

                if (Character.isDigit(c))
                    size /= c - '0';
                else
                    size--;
            }

            throw null;
        }
    }

}
