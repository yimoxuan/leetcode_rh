package com.leetcode.learning.rh;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.max;

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        int T = sc.nextInt();
//        for (int index=0; index < T; index ++) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int [] nums = new int[n];
//            int allCount = 0;
//            for (int i = 0; i < n; i++){
//                nums[i] = sc.nextInt();
//                allCount += nums[i];
//            }
//            int maxRes = 0;
//            int [][] table = new int[n + 1][allCount+1];
//            table[0][0] = 1;
//            for (int i = 1; i <= n; i++) {
//                for (int j = 0; j <= allCount; j++) {
//                    if (j < nums[i-1])
//                        continue;
//                    table[i][j] = max(table[i-1][j - nums[i-1]], table[i-1][j]);
//                    if (j % m == 0 && table[i][j] != 0 && j > maxRes){
//                        maxRes = j;
//                    }
//                }
//            }
//            System.out.println(allCount - maxRes);
//        }
//    }
//}


//
//import java.io.BufferedInputStream;
//import java.util.Scanner;
//
//public class Main {
//    private int max_res = 0;
//
//    private void dfs(int [] nums, int index, int count, int m) {
//        if (count % m == 0 && count > max_res)
//            max_res = count;
//        if (index >= nums.length)
//            return;
//        dfs(nums, index+1, count + nums[index], m);
//        dfs(nums, index+1, count, m);
//    }
//
//    public static void main(String[] args) {
//        Main main = new Main();
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        int T = sc.nextInt();
//        for (int index=0; index < T; index ++) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int [] nums = new int[n];
//            int allCount = 0;
//            for (int i = 0; i < n; i++){
//                nums[i] = sc.nextInt();
//                allCount += nums[i];
//            }
//            main.dfs(nums, 0, 0, m);
//            System.out.println(allCount - main.max_res);
//            main.max_res = 0;
//        }
//    }
//}


//import java.io.BufferedInputStream;
//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//import static java.lang.Math.max;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        int n = sc.nextInt();
//        ArrayList<ArrayList<Integer>> numList = new ArrayList<>();
//        for (int i=0; i<n; i++) {
//            ArrayList<Integer> tmp = new ArrayList<>();
//            int m = sc.nextInt();
//            for (int k=0; k<m; k++) {
//                tmp.add(sc.nextInt());
//            }
//            numList.add(new ArrayList<>(tmp));
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        int k = sc.nextInt();
//        for (int i = 0; i<k; i++) {
//            queue.clear();
//            int p = sc.nextInt();
//            for (int j =0; j < p; j++) {
//                int q = sc.nextInt();
//                queue.addAll(numList.get(q-1));
//            }
//            int kmin = sc.nextInt();
//            for(int it =0; it < kmin-1; it++)
//                queue.poll();
//            System.out.println(queue.poll());
//        }
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        int k = sc.nextInt();
//        for (int i = 0; i<k; i++) {
//            int n = sc.nextInt();
//            int [] nums = new int[n];
//            int point = -1;
//            for (int j = 0; j<n; j++) {
//                nums[j] = sc.nextInt();
//                if (j != 0 && nums[j] > nums[j-1]){
//                    if (point == -1){
//                        point = j-1;
//                    }
//                    else{
//                        point = -2;
//                    }
//                }
//            }
//            if (point == -1){
//                System.out.println("Y");
//            }
//            else{
//                if (point != -2 && nums[0] <= nums[nums.length-1])
//                    System.out.println("Y");
//                else
//                    System.out.println("N");
//            }
//        }
//    }
//}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        int T = scanner.nextInt();
        int [] nums = new int[T];
        int [] left = new int[T];
        int [] right = new int[T];
        int max_length = 0;
        for (int i=0; i<T; i++) {
            nums[i] = scanner.nextInt();
            if (i != 0 && nums[i] >= nums[i-1])
                left[i] = left[i-1] + 1;
        }
        for (int i=T-2; i>=0; i--) {
            if (nums[i] > nums[i+1])
                right[i] = right[i+1] + 1;
            if (left[i] + right[i] + 1 > max_length && left[i] > 0 && right[i] > 0)
                max_length = left[i] + right[i] + 1;
        }
        printWriter.print(max_length);
        printWriter.flush();
    }

    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i=postorder.length-1; i>=0; i--) {
            if (postorder[i] > root) return false;
            while (stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}
