package com.leetcode.learning.rh.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Quest_E_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int []> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i=0; i<k; i++)
            priorityQueue.add(new int[] {nums[i], i});
        int [] res = new int[nums.length-k+1];
        res[0] = priorityQueue.peek()[0];
        for(int i=k; i<nums.length; i++){
            priorityQueue.add(new int [] {nums[i], i});
            while(true) {
                int [] tmp = priorityQueue.peek();
                if (tmp[1] > i-k){
                    res[i-k+1] = tmp[0];
                    break;
                }
                else{
                    priorityQueue.poll();
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Quest_E_239 quest_e_239 = new Quest_E_239();
        System.out.println(quest_e_239.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7},3));
    }
}
