package com.leetcode.learning.rh;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Quest1295 {

    public int findNumbers(int[] nums) {
        List<Integer> ints = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int) ints.stream().filter(item -> String.valueOf(item).length() % 2 == 0).count();
    }

    public static void main(String[] args) {

        System.out.println(new Quest1295().findNumbers(new int[] {12,345,2,6,7896}));

    }
}
