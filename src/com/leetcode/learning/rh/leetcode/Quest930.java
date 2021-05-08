package com.leetcode.learning.rh.leetcode;

public class Quest930 {
    class Solution {
        public int numSubarraysWithSum(int[] A, int S) {
            if (A.length==0){
                return S==0 ? 1 : 0;
            }
            int [] sum = new int[A.length];
            sum[0] = A[0];
            for (int i=1; i<A.length; i++){
                sum[i] = sum[i-1] + A[i];
            }
            int time = 0;
            for (int i=0; i<A.length; i++) {
                for (int j=i+1; j<A.length; j++) {
                    if (sum[j] - sum[i] + A[i] == S)
                        time += 1;
                }
            }
            return time;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest930().new Solution();
        System.out.println(solution.numSubarraysWithSum(new int[] {
                1,0,1,0,1
        }, 2));
    }
}
