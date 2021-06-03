package com.leetcode.learning.rh.dp;

import java.util.Arrays;
import java.util.Comparator;

public class Quest646 {

    private class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (int[] o1, int[] o2) -> {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            });
            int [] table = new int[pairs.length];
            Arrays.fill(table, 1);
            int res = 0;
            for (int i=0; i<pairs.length; i++) {
                for(int j=i-1; j>=0; j--){
//                    System.out.println(pairs[i][0] + "  " + pairs[j][1]);
                    if (pairs[i][0] > pairs[j][1] && table[i] < table[j]+1)
                        table[i] = table[j]+1;
                }
                if (res < table[i])
                    res = table[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest646().new Solution();
        System.out.println(solution.findLongestChain(new int[][] {
                {1, 2},
                {2, 3},
                {3, 4}
        }));
    }

}
