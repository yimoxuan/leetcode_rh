package com.leetcode.learning.rh;

/**
 * 线段树
 *
 * 例题   307
 * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值更新为 val
 * int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + nums[left + 1], ..., nums[right]）
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class SegmentTree {
    /**
     * 没有用tree[0]
     */
    int[] tree;
    int n;
    public void NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }
    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }


    class Solution2 {
        class NumArray {

            private int[] b;
            private int len;
            private int[] nums;

            public NumArray(int[] nums) {
                this.nums = nums;
                double l = Math.sqrt(nums.length);
                len = (int) Math.ceil(nums.length / l);
                b = new int[len];
                for (int i = 0; i < nums.length; i++) {
                    b[i / len] += nums[i];
                }
            }

            public int sumRange(int i, int j) {
                int sum = 0;
                int startBlock = i / len;
                int endBlock = j / len;
                if (startBlock == endBlock) {
                    for (int k = i; k <= j; k++) {
                        sum += nums[k];
                    }
                } else {
                    for (int k = i; k <= (startBlock + 1) * len - 1; k++) {
                        sum += nums[k];
                    }
                    for (int k = startBlock + 1; k <= endBlock - 1; k++) {
                        sum += b[k];
                    }
                    for (int k = endBlock * len; k <= j; k++) {
                        sum += nums[k];
                    }
                }
                return sum;
            }

            public void update(int i, int val) {
                int b_l = i / len;
                b[b_l] = b[b_l] - nums[i] + val;
                nums[i] = val;
            }
        }
    }

}
