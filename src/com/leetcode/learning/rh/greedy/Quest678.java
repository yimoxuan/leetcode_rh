package com.leetcode.learning.rh.greedy;

public class Quest678 {
    class Solution {
        public boolean checkValidString(String s) {
            int [] count = new int[] {0, 0};
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    count[0] += 1;
                    count[1] += 1;
                }
                else if (c == ')') {
                    if (count[0] > 0)
                        count[0] -= 1;
                    count[1] -= 1;
                }
                else {
                    count[1] += 1;
                    if (count[0] > 0)
                        count[0] -= 1;
                }
                if (count[1] < 0)
                    return false;
            }
            return count[0] == 0;
        }
    }
}
