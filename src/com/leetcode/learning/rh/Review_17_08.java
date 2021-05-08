package com.leetcode.learning.rh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Review_17_08 {
    class Solution {
        public int bestSeqAtIndex(int[] height, int[] weight) {
            int [][] arr = new int[height.length][2];
            for (int i=0; i<height.length; i++){
                arr[i][0] = height[i];
                arr[i][1] = weight[i];
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0])
                        return o1[0] - o2[0];
                    return o1[1] - o2[1];
                }
            });
            int [] table = new int[height.length];
            int max_res = 0;
            for (int i=0; i<height.length; i++) {
                table[i] = 1;
                for(int j = i-1; j>=0; j--){
                    if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1] && table[j] + 1 > table[i])
                        table[i] = table[j] + 1;
                }
                if (table[i] > max_res)
                    max_res = table[i];
            }
            return max_res;
        }
    }

}
