package com.leetcode.learning.rh;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class max_router {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] nums = new int[n];
        for (int i=0;i <n; i++)
            nums[i] = sc.nextInt();
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n-k+1; i++) {
            hashMap.clear();
            int min_num = nums[i];
            int max_num = nums[i];
            for (int j = i; j < i+k; j++){
                if (hashMap.keySet().contains(nums[j]))
                    hashMap.put(nums[j], hashMap.get(nums[j]) + 1);
                else
                    hashMap.put(nums[j], 1);
                if (hashMap.get(max_num) < hashMap.get(nums[j]))
                    max_num = nums[j];
                if (nums[j] < min_num)
                    min_num = nums[j];
            }
            if (hashMap.get(max_num).equals(1))
                res.add(min_num);
            else
                res.add(max_num);
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        for (int index = 0; index < res.size(); index ++)
            out.println(res.get(index));
        out.flush();
    }
}
