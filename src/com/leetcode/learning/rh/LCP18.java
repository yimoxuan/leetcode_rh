package com.leetcode.learning.rh;

import java.util.HashMap;
import java.util.TreeSet;

public class LCP18 {
    class Solution {
        public int breakfastNumber(int[] staple, int[] drinks, int x) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            TreeSet<Integer> integers = new TreeSet<>();
            for (int i : drinks) {
                integers.add(i);
                hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
            }
            int res = 0;
            for (int i : staple) {
                Integer k = integers.floor(x-i + 1);
                if (k != null)
                    res = (res + hashMap.get(k)) % 1000000007;
            }
            return res;
        }
    }
}
