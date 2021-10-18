package com.leetcode.learning.rh.bit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Quest756_N {

    class Solution {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            int[][] T = new int[1 << 7][1 << 7];
            for (String triple: allowed) {
                int u = 1 << (triple.charAt(0) - 'A');
                int v = 1 << (triple.charAt(1) - 'A');
                int w = 1 << (triple.charAt(2) - 'A');
                for (int b1 = 0; b1 < (1 << 7); ++b1) if ((u & b1) > 0)
                    for (int b2 = 0; b2 < (1 << 7); ++b2) if ((v & b2) > 0)
                        T[b1][b2] |= w;
            }

            int[] state = new int[bottom.length()];
            int t = 0;
            for (char c: bottom.toCharArray())
                state[t++] = 1 << (c - 'A');
            while (t-- > 1)
                for (int i = 0; i < t; ++i)
                    state[i] = T[state[i]][state[i+1]];
            return state[0] > 0;
        }
    }


    class Solution1 {
        int[][] T;
        Set<Long> seen;

        public boolean pyramidTransition(String bottom, List<String> allowed) {
            T = new int[7][7];
            for (String a: allowed)
                T[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');

            seen = new HashSet();
            int N = bottom.length();
            int[][] A = new int[N][N];
            int t = 0;
            for (char c: bottom.toCharArray())
                A[N-1][t++] = c - 'A';
            return solve(A, 0, N-1, 0);
        }

        //A[i] - the ith row of the pyramid
        //R - integer representing the current row of the pyramid
        //N - length of current row we are calculating
        //i - index of how far in the current row we are calculating
        //Returns true iff pyramid can be built
        public boolean solve(int[][] A, long R, int N, int i) {
            if (N == 1 && i == 1) { // If successfully placed entire pyramid
                return true;
            } else if (i == N) {
                if (seen.contains(R)) return false; // If we've already tried this row, give up
                seen.add(R); // Add row to cache
                return solve(A, 0, N-1, 0); // Calculate next row
            } else {
                // w's jth bit is true iff block #j could be
                // a parent of A[N][i] and A[N][i+1]
                int w = T[A[N][i]][A[N][i+1]];
                // for each set bit in w...
                for (int b = 0; b < 7; ++b) if (((w >> b) & 1) != 0) {
                    A[N-1][i] = b; //set parent to be equal to block #b
                    //If rest of pyramid can be built, return true
                    //R represents current row, now with ith bit set to b+1
                    // in base 8.
                    if (solve(A, R * 8 + (b+1), N, i+1)) return true;
                }
                return false;
            }
        }
    }
}
