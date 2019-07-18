package com.dev.devinspringboot.struts.queue;

import java.util.Arrays;

/**
 * 循环队列
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size; // 队列里面有多少个元素


    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; // 有意的浪费一个格子 因为tail指向的时候即将入队的角标
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        // 判断队列是否为满的
        if ((tail + 1) % data.length == front) {
            // 扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length; // 循环队列操作
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空,不能出队");
        }
        E ret = data[front];
        data[front] = null; // 取消闲散对象
        front = (front + 1) % data.length;
        size --;
        // 缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    /**
     * 扩容
     * @param nweCapacity
     */
    private void resize(int nweCapacity) {
        E[] newData = (E[]) new Object[nweCapacity];
        for (int i = 0; i < size; i++) {
            // 有偏移 防止越界
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
