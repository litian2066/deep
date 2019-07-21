package com.dev.devinspringboot.struts.link;

import com.dev.devinspringboot.struts.queue.ArrayQueue;
import com.dev.devinspringboot.struts.queue.LoopQueue;
import com.dev.devinspringboot.struts.queue.Queue;
import com.dev.devinspringboot.struts.stack.ArrayStack;
import com.dev.devinspringboot.struts.stack.Stack;

import java.util.Random;

/**
 * 数组和链表的时间差异不大, 虽然链表没有容积问题 但是会有new的操作
 */
public class Main {

    /**
     * 测试使用q运行opCount个入栈和出栈的操作所需要的时间, 单位: 秒
     * @param q
     * @param opCount
     * @return
     */
    private static double testStack(Stack<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        // ...
        Random random = new Random();
        // 入队
        for (int i = 0; i < opCount; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE)); // 从0 到int 最大值的随机数
        }

        // 出队
        for (int i = 0; i < opCount; i++) {
            q.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }


    public static void main(String[] args) {
        /*LoopQueue<Integer> loopQueue = new LoopQueue<>();

        for (int i = 0; i < 9; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i % 3 == 2) {
                System.out.println("出队");
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }*/
        // 测试数组队列和循环队列的效率
        int opCount = 100000;

        Stack<Integer> arrayQueue = new ArrayStack<>();
        double time = testStack(arrayQueue, opCount);
        System.out.println("ArrayStack: " + time + "s"); // 5 s
        Stack<Integer> loopQueue = new LinkedListStack<>();
        double time1 = testStack(loopQueue, opCount);
        System.out.println("LinkedStack: " + time1 + "s"); // 0.02
    }
}
