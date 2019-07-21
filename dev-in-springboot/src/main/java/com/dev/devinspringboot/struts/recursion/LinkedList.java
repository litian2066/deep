package com.dev.devinspringboot.struts.recursion;

import java.util.List;

public class LinkedList<E> {

    /**
     * 内部类
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            Node cur = this;
            while (cur != null) {
                res.append(cur.e + "->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }
    // 头结点
    // private Node head;
    /**
     * 为链表添加一个虚拟头结点
     * 这样添加新节点的时候不需要对头部节点特殊处理了 直接找到对应的位置即可
     */
    private Node dummyHead;
    // 节点数
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
      return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        /*Node node = new Node(e);
        node.next = head;
        head = node;*/

        // head = new Node(e, head);
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("");
        }
        /*if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;

            // prev.next = new Node(e, prev.next)0
        }*/
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表尾部添加新的元素
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的index个位置的元素
    public E get(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public  E getLast() {
        return get(size - 1);
    }

    // 修改操作
    public void set(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
    }

    // 从链表中删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public Node createNodeByArray(E[] arr) {
        return createNodeByArray(arr, 0);
    }

    private Node createNodeByArray(E[] arr, int l) {
        if (arr.length == l) {
            return null;
        }
        Node node = new Node(arr[l]);
        node.next = createNodeByArray(arr, l + 1);
        return node;
    }

    public Node createNodeByList(List<E> list) {
        return createNodeByList(list, 0);
    }

    private Node createNodeByList(List<E> list, int l) {
        if (list.isEmpty()) {
            return null;
        }
        Node node = new Node(list.get(l));
        node.next = createNodeByList(list, l + 1);
        return node;
    }

    public static void main(String[] args) {
        Integer num[] = {1, 4, 5, 6, 7};
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        LinkedList.Node nodeByArray =  integerLinkedList.createNodeByArray(num);
        System.out.println(nodeByArray);
    }
}
