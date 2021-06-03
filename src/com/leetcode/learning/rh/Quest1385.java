package com.leetcode.learning.rh;

import com.leetcode.learning.rh.leetcode.Quest1309;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Quest1385 {
    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            TreeSet treeSet = new TreeSet();
            for (int num: arr2)
                treeSet.add(num);
            int res = 0;
            for (int num : arr1) {
                Object floor = treeSet.floor(num), ceil = treeSet.ceiling(num);
                if ((floor == null || num - (int) floor  > d) && (ceil == null || (int)ceil - num > d))
                    res += 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1385().new Solution();
        System.out.println(solution.findTheDistanceValue(new int[] {1,2,3}, new int[] {4, 5, 6}, 2));
    }
}
