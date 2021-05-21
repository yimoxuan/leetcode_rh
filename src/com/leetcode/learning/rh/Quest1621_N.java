package com.leetcode.learning.rh;

public class Quest1621_N {
    class Solution {
        public int numberOfSets(int n, int k) {
            int base = 1000000007;
            int [][]table = new int[n+1][k+1];
            table[2][1] = 1;
            table[2][0] = 1;
            table[0][0] = 1;
            table[1][0] = 1;
            table[1][1] = 0;
            long tmp = 0;
            for (int i=3; i<=n; i++) {
                table[i][0] = 1;
                for (int m = 1; m<=k; m++) {
//                    tmp = table[i-1][m];
//                    for (int j=i-1; j>=1; j--) {
//                        tmp += table[j][m-1];
//                        tmp %= 1000000007;
//                    }
                    tmp = table[i-1][m];
                    tmp += table[i-1][m-1];
                    tmp %= base;
                    tmp -= table[i-2][m];
                    tmp %= base;
                    tmp += table[i-1][m];
                    tmp %= base;
                    table[i][m] = (int) tmp;
                }
            }
            return table[n][k];

        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        Solution solution = new Quest1621_N().new Solution();
        System.out.println(solution.numberOfSets(921, 753));
    }
}
