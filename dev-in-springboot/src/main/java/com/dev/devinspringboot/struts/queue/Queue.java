package com.dev.devinspringboot.struts.queue;

public interface Queue<E> {

    int getSize();
    boolean isEmpty();

    /**
     * 入队操作
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 查询队首元素
     * @return
     */
    E getFront();
}
