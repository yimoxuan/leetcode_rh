package com.leetcode.learning.rh.leetcode;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;

public class Offer10_2 {
        public HashMap<Integer, Integer> hashMap = new HashMap<>();

        private long getNum(int n) {
            if (n == 1)
                return 1L;
            if (n == 2)
                return 2L;
            if (hashMap.keySet().contains(n))
                return hashMap.get(n);
            int res = (int) (getNum(n-1) + getNum(n-2)) % 1000000007;
            hashMap.put(n, res);
            return res;
        }

        public int numWays(int n) {
            return (int) getNum(n);
        }

    public static void main(String[] args) {
        Offer10_2 offer10_2 = new Offer10_2();
        System.out.println(offer10_2.numWays(100));
        System.out.println(offer10_2.hashMap.size());
    }
}
