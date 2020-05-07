package com.onlyone.algorithm.tree;

public class Solution {

    public ListNode sortList(ListNode head) {

        return merge(head);
    }

    private ListNode getMidNode(ListNode head) {

        ListNode preHead = null;
        ListNode mid = head;

        while (head != null && head.next != null) {
            preHead = mid;
            mid = mid.next;
            head = head.next.next;
        }
        if (preHead != null) {
            preHead.next = null;
        }
        return mid;
    }

    private ListNode merge(ListNode head) {

        ListNode mid = getMidNode(head);

        if (mid == head) {
            return mid;
        }
        //左边排好
        ListNode leftNode = merge(head);
        //右边排好
        ListNode midNode = merge(mid);
        //整体排序
        return mergeAll(leftNode, midNode);
    }

    private ListNode mergeAll(ListNode leftHead, ListNode rightHead) {
        ListNode curPtr = new ListNode();
        ListNode newHead = curPtr;

        while (leftHead != null && rightHead != null) {
            if (leftHead.val < rightHead.val) {
                curPtr.next = leftHead;
                leftHead = leftHead.next;
            } else {
                curPtr.next = rightHead;
                rightHead = rightHead.next;
            }
            curPtr = curPtr.next;
        }
        if (leftHead != null) {
            curPtr.next = leftHead;
        }
        if (rightHead != null) {
            curPtr.next = rightHead;
        }
        return newHead;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode() {
            val = 0;
        }

        public static ListNode build() {

            ListNode cur = new ListNode(4);
            ListNode head = cur;

            cur.next = new ListNode(1);
            cur = cur.next;

            cur.next = new ListNode(2);
            cur = cur.next;

            cur.next = new ListNode(3);

            return head;
        }

    }
}

