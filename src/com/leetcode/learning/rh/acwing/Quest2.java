package com.leetcode.learning.rh.acwing;

import java.io.BufferedInputStream;
import java.util.Scanner;
import static java.lang.Math.max;

/**
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 * 第 i 件物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 *
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 */
public class Quest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int [] weight = new int[N];
        int [] score = new int[N];
        for (int i=0; i<N; i++) {
            weight[i] = scanner.nextInt();
            score[i] = scanner.nextInt();
        }
        int [] table = new int[V+1];
        for (int i=0; i<N; i++) {
            for (int j=V; j>=0; j--) {
                if (j >= weight[i])
                    table[j] = max(table[j], table[j-weight[i]] + score[i]);
            }
        }
        System.out.println(table[V]);
    }
}
