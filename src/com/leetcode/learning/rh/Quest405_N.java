package com.leetcode.learning.rh;

public class Quest405_N {
    /**
     * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
     *
     * 注意:
     *
     * 十六进制中所有字母(a-f)都必须是小写。
     * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
     * 给定的数确保在32位有符号整数范围内。
     * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public String toHex(int num) {
            if (num == 0) return "0";
            String hex = "0123456789abcdef", ans = "";
            while(num != 0 && ans.length() < 8){
                ans = hex.charAt(num & 0xf) + ans;
                num >>=  4;
            }
            return ans;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest405_N().new Solution();
        System.out.println(solution.toHex(-1));
    }
}
