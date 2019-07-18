package com.dev.devinspringboot.struts.queue;
/**
 数组队列是一种先进先出的数据结构（FIFO）
    void enqueue(E) O(1) 均摊
    E dequeue()     O(n) 出队的时候拿走第一个元素 后面的数据会向前挪动
    E getFront()    O(1)
    int getSize()   O(1)
    boolean isEmpty() O(1)
 局限性： 出队操作是O（n）的复杂, 出队的时候会有挪动的操作 所以时间复杂度是O(N)
 想法: 可以记下队首和队尾的index
        所以出队的时候只需要挪动队首的角标 入队的时候挪动队尾的角标 这样的操作, 前面就会有多余的空间 可以重新
 再使用这些空间 就形成了循环队列
    front == tail 队列为空, (tail + 1) % capacity = front 队列满
 **/