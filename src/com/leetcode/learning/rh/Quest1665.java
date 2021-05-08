package com.leetcode.learning.rh;

import java.util.Arrays;
import java.util.Comparator;

public class Quest1665 {
    class Solution {
        public int minimumEffort(int[][] tasks) {
            Arrays.sort(tasks, ((o1, o2) -> {
                if ((o2[1]-o2[0])-(o1[1]-o1[0]) == 0)
                    return o2[1] - o1[1];
                else
                    return (o2[1]-o2[0])-(o1[1]-o1[0]);
            }));
            int left = 0;
            int res = 0;
            for (int i =0; i<tasks.length; i++) {
                if (left < tasks[i][1]) {
                    res += tasks[i][1] - left;
                    left= tasks[i][1] - tasks[i][0];
                }
                else{
                    left = left - tasks[i][0];
                }

            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1665().new Solution();
        System.out.println(solution.minimumEffort(new int[][] {{1,3},{2,4},{10,11},{10,12},{8,9}}));
    }
}
