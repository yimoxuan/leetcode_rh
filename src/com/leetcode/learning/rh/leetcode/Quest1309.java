package com.leetcode.learning.rh.leetcode;

/**
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quest1309 {
    class Solution {
        public String freqAlphabets(String s) {
            int index = 0;
            StringBuffer stringBuffer = new StringBuffer();
            while (index < s.length()) {
                if (    index + 2 < s.length() &&
                        (
                                (s.charAt(index) == '1' && s.charAt(index+2) == '#') ||
                                        (s.charAt(index) == '2' && s.charAt(index+1) <= '6' && s.charAt(index+2) == '#')
                                )
                ) {
                    char a = (char) ('a' + (Integer.valueOf("" + s.charAt(index) + s.charAt(index + 1)) - 1));
                    stringBuffer.append(a);
                    index += 3;
                }
                else{
                    stringBuffer.append((char) ('a' + (Integer.valueOf("" + s.charAt(index)) - 1)));
                    index += 1;
                }
            }
            return stringBuffer.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1309().new Solution();
        System.out.println(solution.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
