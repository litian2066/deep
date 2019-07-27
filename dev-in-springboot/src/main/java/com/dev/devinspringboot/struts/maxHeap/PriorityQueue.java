package com.dev.devinspringboot.struts.maxHeap;

import com.dev.devinspringboot.struts.queue.Queue;

/**
 * 优先队列(是一个有顺序的队列)
 * 使用最大堆来实现
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        this.maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
