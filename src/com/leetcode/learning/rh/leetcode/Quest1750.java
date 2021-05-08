package com.leetcode.learning.rh.leetcode;

/**
 *
 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：

 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 前缀和后缀在字符串中任意位置都不能有交集。
 前缀和后缀包含的所有字符都要相同。
 同时删除前缀和后缀。
 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。


 */

public class Quest1750 {
    class Solution {
        public int minimumLength(String s) {
            int begin = 0, end = s.length() -1;

            while(begin <= end) {
                char leftChar = s.charAt(begin);
                if(begin <= end && s.charAt(end) == leftChar && begin != end) {
                    while(s.charAt(end) == leftChar)
                        end -= 1;
                    while (begin <= end && leftChar == s.charAt(begin))
                        begin += 1;
                }
                else{
                    return end - begin + 1;
                }
            }
            return 0;
        }
    }
}
