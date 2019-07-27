package com.dev.devinspringboot.struts.array;

import java.util.Arrays;

/**
 * 自己封装数组
 */
public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数, 传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size++] = e;
    }

    /**
     * 在制定位置插入元素, 需要挪动元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        // 验证index是否合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add is failed. Require index >= 0 and index < size");
        }
        // 扩容
        if (size == data.length) {
           resize(2 * data.length);
        }
        // 挪动位置
        for (int i = size; i > index - 1 ; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 向数组头添加一个元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 获取index索引位置的元素
    public E get(int index) {
        // 验证index是否合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get is failed. Require index >= 0 and index < size");
        }
        return data[index];
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        // 验证index是否合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove is failed. Require index >= 0 and index < size");
        }
        E ret = data[index];
        for (int i = index +1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // 去除闲散对象
        // 为了防止时间复杂度震荡,故不能在数组长度小于一半的时候进行缩容, 要等到少于四分之一的时候进行缩容;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    // 交换
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("不能交换，交换双方索引异常");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
