package com.leetcode.learning.rh.leetcode;

import java.util.List;
import java.util.SortedSet;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteChongfu {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode tmpHead = new ListNode(-1);
        ListNode nowNode = pHead;
        ListNode preNode = null;
        ListNode fatherNode = tmpHead;
        boolean fag = true;
        while (nowNode != null) {
            if (preNode != null && nowNode.val == preNode.val){
                fag = false;
                nowNode = nowNode.next;
            }
            else{
                if (fag && preNode != null){
                    fatherNode.next = preNode;
                    fatherNode = fatherNode.next;
                    fatherNode.next = null;
                }
                fag = true;
                preNode = nowNode;
                nowNode = nowNode.next;
            }
        }
        if (fag && preNode != null){
            fatherNode.next = preNode;
            fatherNode = fatherNode.next;
            fatherNode.next = null;
        }
        return tmpHead.next;
    }

    public static void main(String[] args) {
        DeleteChongfu deleteChongfu = new DeleteChongfu();
        ListNode listNode = new ListNode(1);
        ListNode head;
        listNode.next = new ListNode(1);
        head = listNode.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(1);
        System.out.println(deleteChongfu.deleteDuplication(listNode));

    }
}
