package com.dev.devinspringboot.struts.link;

import com.dev.devinspringboot.struts.queue.Queue;

public class LinkListedQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }
    }

    private Node head, tail;
    private int size;

    public LinkListedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // 入队
    @Override
    public void enqueue(E e) {
        // 如果队尾为空
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            Node newTail = new Node(e);
            tail.next = newTail;
            tail = newTail;
        }
        size ++;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空, 不能完成操作");
        }
        Node ret = head;
        head = head.next;
        ret.next = null;
        // 假设出队完成后队列为空
        if (head == null) {
            tail = null;
        }
        size --;
        return ret.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空, 不能完成操作");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("LinkedQueue: Front: [");
        Node cur = head;
        while (cur != null) {
            res.append(cur.e +"->");
            cur = cur.next;
        }
        res.append(" ] Taile");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkListedQueue<Integer> linkListQueque = new LinkListedQueue<>();
        for (int i = 0; i < 10; i++) {
            linkListQueque.enqueue(i);
            System.out.println(linkListQueque.toString());
            if (i % 3 == 0) {
                linkListQueque.dequeue();
                System.out.println("出队: " + linkListQueque.toString());
            }
        }
    }
}
