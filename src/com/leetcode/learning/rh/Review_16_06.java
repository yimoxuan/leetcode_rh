package com.leetcode.learning.rh;

import java.util.Arrays;
import static java.lang.StrictMath.abs;

public class Review_16_06 {
    class Solution {
        public int smallestDifference(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            int x = 0, y = 0;
            int min_dif = 0x7ffffff;
            while (x < a.length && y < b.length) {
                if (abs(a[x] - b[y]) < min_dif) {
                    min_dif = abs(a[x] - b[y]);
                }
                if(x == a.length-1)
                    y += 1;
                else{
                    if (y == b.length-1)
                        x += 1;
                    else{
                        if (a[x] < b[y])
                            x += 1;
                        else
                            y += 1;
                    }
                }
            }
            return min_dif;
        }
    }

    public static void main(String[] args) {
        Review_16_06 review_16_06 = new Review_16_06();
        Solution solution = review_16_06.new Solution();
        System.out.println(solution.smallestDifference(
                new int [] {1, 3, 15, 11, 2}, new int []{23, 127, 235, 19, 8}
        ));
        System.out.println(Integer.MAX_VALUE);
    }
}
