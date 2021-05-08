package com.leetcode.learning.rh;

import java.util.Arrays;

/**
 * 给你一个二进制矩阵 matrix ，它的大小为 m x n ，你可以将 matrix 中的 列 按任意顺序重新排列。
 *
 * 请你返回最优方案下将 matrix 重新排列后，全是 1 的子矩阵面积。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-submatrix-with-rearrangements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest1727_N {
    class Solution {
        public int largestSubmatrix(int[][] matrix) {
            int n=matrix.length;
            int m=matrix[0].length;
            int res=0;
            for(int i=1;i<n;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][j]==1){
                        //记录向上连续1的个数
                        matrix[i][j]+=matrix[i-1][j];
                    }
                }
            }
            for(int i=0;i<n;i++){
                Arrays.sort(matrix[i]);
                for(int j=m-1;j>=0;j--){
                    //更新矩形的最大高度
                    int height=matrix[i][j];
                    //更新最大面积
                    res=Math.max(res,height*(m-j));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
