package com.dev.devinspringboot.struts.link;

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
            return e.toString();
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

    /**
     * 删除元素
     * @param e
     * @return
     */
    public E removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                return delNode.e;
            } else {
                prev = prev.next;
            }
        }
        return null;
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
}
