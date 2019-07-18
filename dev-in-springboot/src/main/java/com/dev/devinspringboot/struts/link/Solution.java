package com.dev.devinspringboot.struts.link;

import java.util.List;

/**
 * 删除链表中某个val的所有元素
 * 删除链表中的一个节点需要找到该节点的前一个节点
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        // 如果删除的节点是头结点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;

        }
        // 如果链表中所有的节点都是要删除的节点
        if (head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
