package com.leetcode.learning.rh.linklist;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class Quest92 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode beginNode = null;
            ListNode newHead = new ListNode(0);
            ListNode temNode = head;
            ListNode newEnd = null;
            int count = 0;
            while(count < m){
                beginNode = temNode;
                temNode = temNode.next;
                count += 1;
            }
            newEnd = temNode;
            while (count <= n) {
                ListNode node = newHead.next;
                newHead.next = temNode;
                temNode = temNode.next;
                newHead.next.next = node;
                count += 1;
            }
            newEnd.next = temNode;
            if (beginNode == null)
                return newHead.next;
            beginNode.next = newHead.next;
            return head;
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(0);
        ListNode temHead = head;
        for (int num : nums){
            temHead.next = new ListNode(num);
            temHead = temHead.next;
        }
        Solution solution = new Quest92().new Solution();
        System.out.println(solution.reverseBetween(head.next, 2, 4));
    }
}
