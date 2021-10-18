package com.leetcode.learning.rh;

import static java.lang.Math.min;

public class Quest1768 {
    class Solution {

        public String mergeAlternately(String word1, String word2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i<min(word1.length(), word2.length()); i++) {
                stringBuilder.append(word1.charAt(i));
                stringBuilder.append(word2.charAt(i));
            }
            if (word1.length() < word2.length()) {
                stringBuilder.append(word2.substring(min(word1.length(), word2.length())));
            }
            else if (word1.length() > word2.length()) {
                stringBuilder.append(word1.substring(min(word1.length(), word2.length())));
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1768().new Solution();
        System.out.println(solution.mergeAlternately("abczt", "pqr"));
    }
}
