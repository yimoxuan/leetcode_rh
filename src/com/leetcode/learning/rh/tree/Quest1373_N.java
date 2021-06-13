package com.leetcode.learning.rh.tree;


/**
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *
 * 二叉搜索树的定义如下：
 *
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest1373_N {

    /**
     * # Definition for a binary tree node.
     * # class TreeNode:
     * #     def __init__(self, val=0, left=None, right=None):
     * #         self.val = val
     * #         self.left = left
     * #         self.right = right
     * class Solution:
     *     def is_BST(self, rt: TreeNode, min_val: int, max_val: int) -> bool:     #判断是否为BST
     *         if rt == None:
     *             return True
     *         return min_val < rt.val < max_val and self.is_BST(rt.left, min_val, rt.val)==True and self.is_BST(rt.right, rt.val, max_val)==True
     *
     *     def tree_sum(self, rt: TreeNode) -> int:            #当前以rt为root的这棵树的和
     *         if rt == None:
     *             return 0
     *         cur_tree_sum = rt.val + self.tree_sum(rt.left) + self.tree_sum(rt.right)
     *         self.res = max(self.res, cur_tree_sum)          #优化res
     *         return cur_tree_sum
     *
     *     def find_max_sum_BST(self, rt: TreeNode) -> None:   #dfs  查找
     *         if self.is_BST(rt, -0x3f3f3f3f, 0x3f3f3f3f) == True:    #先判断是一棵BST    初始化是NB之处!!!!!!!!!!!!!!!!
     *             self.tree_sum(rt)                           #计算这棵树的和，并优化res
     *             return
     *         self.find_max_sum_BST(rt.left)                  #dfs左子
     *         self.find_max_sum_BST(rt.right)                 #dfs右子
     *
     *     def maxSumBST(self, root: TreeNode) -> int:     #dfs套dfs 没想到没TLE
     *         self.res = 0
     *         self.find_max_sum_BST(root)
     *         return self.res
     */

}
