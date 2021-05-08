package com.leetcode.learning.rh.acwing;

import java.io.BufferedInputStream;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 * 有 N 种物品和一个容量是 V 的背包。
 *
 * 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
 *
 * 接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 */


public class Quest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int weight;
        int score;
        int s;
        int [] table = new int[V+1];
        for (int i=0; i<N; i++) {
            weight = scanner.nextInt();
            score = scanner.nextInt();
            s = scanner.nextInt();
            for (int j=V; j>=0; j--) {
                int k = 1;
                while (j >= weight * k && k <= s) {
                    table[j] = max(table[j], table[j - weight * k] + score * k);
                    k++;
                }
            }
        }
        System.out.println(table[V]);
    }
}
