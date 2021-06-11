package com.leetcode.learning.rh.dp;

/**
 * 给你一个整数数组 arr，请你将该数组分隔为长度最多为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 *
 * 返回将数组分隔变换后能够得到的元素最大和。
 *
 *  
 *
 * 注意，原数组和分隔后的数组对应顺序应当一致，也就是说，你只能选择分隔数组的位置而不能调整数组中的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-for-maximum-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest1043_N {
    /**
     * class Solution:
     *     def maxSumAfterPartitioning(self, arr, k: int):
     *         n=len(arr)
     *
     *         dp=[0]*n
     *
     *         #这是先解决前面几种index小于k的特殊情况
     *         for i in range(k):
     *             dp[i]=max(arr[:i+1])*(i+1)
     *
     *         for i in range(k,n):
     *             possible_li=[]
     *             for span in range(1,k+1):
     *
     *                 #这一步最为关键，这是dp[i]的每种可能。
     *                 #我们把arr[i]框起来，和前面元素组成长度为span的框
     *                 #这种框法得到的最佳解为=框的左侧紧挨着的的最佳解+框的长度*框内的最大元素值
     *                 possible_li.append(dp[i-span]+max(arr[i-span+1:i+1])*span)
     *
     *             #从所有框法得到的可能解里面选最大的，作为最佳解
     *             dp[i]=max(possible_li)
     *
     *         return dp[-1]
     */
}
