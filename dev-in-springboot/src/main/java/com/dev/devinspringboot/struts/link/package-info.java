package com.dev.devinspringboot.struts.link;
/**
    动态数组 栈 队列  底层依托静态数组; 靠resize解决固定容量问题
    链表: 真正的动态数据结构
        * 最简单的动态数据结构
        * 更深入的理解引用
        * 更深入的理解递归
      * 数据存储在节点中(Node)
 *     class Node {
 *         E e;
 *         Node next;
 *     }
 *     优点:
 *      真正的动态, 不需要处理容量固定的问题
 *     缺点:
 *      丧失了随机访问的能力
 *     数组最好用于索引有语音的情况. scores[2]
 *     最大的优点: 支持快速查询
 *     链表不适合用于索引有语意的情况
 *     最大的优点: 动态
 *     时间复杂度:
 *      addLast O(N)
 *      addFirst O(1)
 *      add(index, e) O(N / 2) = O(N)
 *      removeLast(e) O(N)
 *      removeFirst(e) O(1)
 *      remove(index, e) O(N)
 *      set(index, e) O(N)
 *      get/contains/find O(N)
 **/