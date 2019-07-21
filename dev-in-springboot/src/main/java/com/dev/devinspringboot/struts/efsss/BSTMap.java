package com.dev.devinspringboot.struts.efsss;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private BST<K> bst;
    private int size;

    public BSTMap() {
        this.bst = new BST<>();
    }

    @Override
    public void add(K k, V v) {

    }

    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public boolean contains(K k) {
        return false;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public void set(K k, V v) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
