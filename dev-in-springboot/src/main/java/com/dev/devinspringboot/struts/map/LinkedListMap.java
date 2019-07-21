package com.dev.devinspringboot.struts.map;

/**
 * 使用链表实现map
 * @param <K>
 * @param <V>
 */
public class LinkedListMap<K, V> implements Map<K, V> {


    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }


    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }


    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        // 如果没有重复的数据,那么在头结点添加
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        } else {
            node.value = value;
        }
    }


    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (key.equals(prev.next.key)) {
                Node delNode = prev.next;
                prev.next.next = delNode.next;
                delNode.next = null;
                size--;
                return delNode.value;
            } else {
                prev = prev.next;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.value;
    }

    public Node getNode(K k) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(k)) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        return null;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if (node != null) {
            node.value = v;
        } else {
            throw new IllegalArgumentException(k + "不存在");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
