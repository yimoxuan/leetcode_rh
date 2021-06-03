package com.leetcode.learning.rh;

import static java.lang.Math.min;

/**
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 *
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
 *
 * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 *
 * 注意， x + y 表示连接字符串 x 和 y 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-two-strings-to-make-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 这里是或者，不是两者都
 */

public class Quest1616_N {
    class Solution {
        Boolean checkPalindromeFormation(String a, String b) {
            int left = a.length() / 2 - 1;
            left = min(check(a, a, left), check(b, b, left));
            left = min(check(a, b, left), check(b, a, left));
            return left == -1;
        }

        int check(String str_l, String str_r, int left) {
            int right = str_l.length() - 1 - left;
            while (left >= 0 && right < str_l.length()) {
                if (str_l.charAt(left) != str_r.charAt(right)) break;
                left--;
                right++;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1616_N().new Solution();
        System.out.println(solution.checkPalindromeFormation("gabdef", "fecabg"));
    }
}
