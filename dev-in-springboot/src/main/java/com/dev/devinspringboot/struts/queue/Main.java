package com.dev.devinspringboot.struts.queue;

import java.util.Random;

public class Main {

    /**
     * 测试使用q运行opCount个入队和出队的操作所需要的时间, 单位: 秒
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        // ...
        Random random = new Random();
        // 入队
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE)); // 从0 到int 最大值的随机数
        }

        // 出队
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
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

        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double time = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue: " + time + "s"); // 5 s
        Queue<Integer> loopQueue = new LoopQueue<>();
        double time1 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue: " + time1 + "s"); // 0.02
    }
}
