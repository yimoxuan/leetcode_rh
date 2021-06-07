package com.leetcode.learning.rh;

import java.util.Arrays;
import java.util.HashMap;

public class Quest1387 {
//    class Solution {
//        private HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//        public int getKth(int lo, int hi, int k) {
//
//            if (lo == hi) return hi;
//
//            int [] nums = new int[hi-lo+1];
//            for (int i =lo; i<=hi; i++)
//                nums[i] = i;
//            Arrays.sort(nums, (a, b)-> {
//                int a1=0, b1=0;
//                int a2 = (int) a, b2 = (int)b;
//                if (hashMap.keySet().contains(a))
//                    a1 = hashMap.get(a);
//                else{
//                    while(a2 != 1) {
//                        if (a2 % 2 == 1)
//                            a2 = a2 * 3 + 1;
//                        else
//                            a2 /= 2;
//                        a1 += 1;
//                    }
//                }
//                if (hashMap.keySet().contains(b))
//                    b1 = hashMap.get(b);
//                else{
//                    while(b2 != 1) {
//                        if (b2 % 2 == 1)
//                            b2 = b2 * 3 + 1;
//                        else
//                            b2 /= 2;
//                        b1 += 1;
//                    }
//                }
//                //if (a1 == b1)
//                  //  return  a < b;
//
//            });
//        }
//    }

    public static void main(String[] args) {
        Integer [] nums = new Integer[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = i;
        }
        Arrays.sort(nums, (a, b)->a.compareTo(b));
    }
}
