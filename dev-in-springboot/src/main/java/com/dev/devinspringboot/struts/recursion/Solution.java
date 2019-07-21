package com.dev.devinspringboot.struts.recursion;


import java.util.List;

public class Solution {


    private class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int[] arr) {
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val + "->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 最低的情况
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);;
            return head;
        }
        // return head.val == val ? removeElements(head.next, val) : (head.next = removeElements(head.next, val));
    }

    public void test() {
        int[] num = {1, 2, 3, 4, 5, 5, 6};
        ListNode listNode = new ListNode(num);
        ListNode listNode1 = removeElements(listNode, 5);
        System.out.println(listNode1);
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
