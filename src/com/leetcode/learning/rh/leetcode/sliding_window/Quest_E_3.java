package com.leetcode.learning.rh.leetcode.sliding_window;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 */

import java.util.HashMap;

public class Quest_E_3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int longest_res = 0;
        int begin = -1;
        for (int i=0; i<s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                begin = begin < map.get(s.charAt(i)) ? map.get(s.charAt(i)) : begin;
                longest_res = i-begin > longest_res ? i- begin : longest_res;
                map.put(s.charAt(i), i);
            }
            else{
                longest_res = i-begin > longest_res ? i- begin : longest_res;
                map.put(s.charAt(i), i);
            }
        }
        return longest_res;
    }

    public static void main(String[] args) {
        Quest_E_3 quest_e_3 = new Quest_E_3();
        System.out.println(quest_e_3.lengthOfLongestSubstring(new String("abcabcbb")));
    }
}
