package com.dev.devinspringboot.struts.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private BST<K, V> bst;

    public BSTMap() {
        bst = new BST<K, V>();
    }

    @Override
    public void add(K k, V v) {
        bst.add(k, v);
    }

    @Override
    public V remove(K k) {
        return bst.remove(k);
    }

    @Override
    public boolean contains(K k) {
        return bst.contains(k);
    }

    @Override
    public V get(K k) {
        return bst.get(k);
    }

    @Override
    public void set(K k, V v) {
        bst.set(k, v);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
