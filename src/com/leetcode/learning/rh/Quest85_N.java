package com.leetcode.learning.rh;

public class Quest85_N {
//    class Solution {
//        public int maximalRectangle(char[][] matrix) {
//            if (matrix.length == 0)
//                return 0;
//            int [][][] matrix1 = new int[matrix.length][matrix[0].length][2];
//            matrix1[0][0][0] = matrix1[0][0][1] = matrix[0][0] == '1' ? 1 : 0;
//
//            int maxRes = matrix1[0][0][0];
//            for (int i=1; i<matrix.length; i++) {
//                if (matrix[i][0] == '1') {
//                    matrix1[i][0][0] = matrix1[i-1][0][0] + 1;
//                    matrix1[i][0][1] = 1;
//                }
//                if (matrix1[i][0][0] * matrix1[i][0][1] > maxRes)
//                    maxRes = matrix1[i][0][0] * matrix1[i][0][1];
//            }
//            for(int i=1; i<matrix[0].length; i++) {
//                if (matrix[0][i] == '1') {
//                    matrix1[0][i][0] = 1;
//                    matrix1[0][i][1] = matrix1[0][i-1][0] + 1;
//                }
//                if (matrix1[0][i][0] * matrix1[0][i][1] > maxRes)
//                    maxRes = matrix1[0][i][0] * matrix1[0][i][1];
//            }
//
//            for (int i=1; i<matrix.length; i++) {
//                for (int j=1; j<matrix[0].length; j++) {
//                    if (matrix[i][j] == '1') {
//                        matrix1[i][j][0] = Math.min(matrix1[i-1][j-1][0] + 1, matrix1[i-1][j][0]+1);
//                        matrix1[i][j][1] = Math.min(matrix1[i-1][j-1][1] + 1, matrix1[i][j-1][1] + 1);
//                    }
//                    if (matrix1[i][j][0] * matrix1[i][j][1] > maxRes)
//                        maxRes = matrix1[i][j][0] * matrix1[i][j][1];
//                }
//            }
//            return maxRes;
//
//        }
//
//    }
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        int[][] matrix1 = new int[n][m];
        for(int i = 0;i < m;i++){
            if(matrix[0][i] == '1') matrix1[0][i] = 1;
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j < m;j++){
                if(matrix[i][j] == '1')
                    matrix1[i][j] = matrix1[i - 1][j] + 1;
            }
        }
        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(matrix1[i][j] * m <= ans) continue;
                if(matrix1[i][j] != 0){
                    int cnt = 1;
                    for(int k = j + 1;k < m;k++){
                        if(matrix1[i][k] < matrix1[i][j]) break;
                        cnt++;
                    }
                    for(int k = j - 1;k >= 0;k--){
                        if(matrix1[i][k] < matrix1[i][j]) break;
                        cnt++;
                    }
                    ans = Math.max(ans, cnt * matrix1[i][j]);
                }
            }
        }
        return ans;
    }
}

    public static void main(String[] args) {
        Solution solution = new Quest85_N().new Solution();
        System.out.println(solution.maximalRectangle(
                new char[][] {{'1','0','0','0','1'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}
        ));
    }
}
