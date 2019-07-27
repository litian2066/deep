package com.dev.devinspringboot.struts.maxHeap;

import com.dev.devinspringboot.struts.array.Array;

/**
 * 堆的数组表示
 * 泛型必须可以比较
 */
public class
MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }
    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树中的数组表示中， 一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("索引是0，没有父亲节点");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素 Sift Up 上浮
    public void add(E e) {
        data.addLast(e);
        // 维护堆的性质
        siftUp(data.getSize() - 1);
    }

    // 上浮
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 查看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("堆中没有数据，不能查看元素");
        }
        return data.get(0);
    }

    // 取出堆中的最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        // 维护堆的性质
        siftDown(0);
        return ret;
    }

    // 下沉
    private void siftDown(int k) {
        // 判断k是否有左孩子
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            // 判断是否有右孩子， 并且找到两个孩子中最大的
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
                // data[j]是leftChild 和rightChild 中的最大值
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

}
