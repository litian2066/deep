package com.dev.devinspringboot.struts.efsss;

import java.util.LinkedList;
import java.util.Random;

/**
 * 测试
 */
public class App {

    public static void main(String[] args) {
        int opCount = 100000;
//        Set<Integer> set = new LinkedListSet<>();
//        double v1 = testSet(set, opCount);
//        System.out.println("LinkedListSet: " + v1 + " s");

        Set<Integer> bstSet = new BSTSet<>();
        double v2 = testSet(bstSet, opCount);
        System.out.println("bstSet: " + v2 + " s");
    }

    /**
     * 测试使用q运行opCount个入栈和出栈的操作所需要的时间, 单位: 秒
     * @param q
     * @param opCount
     * @return
     */
    private static double testSet(Set<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        // ...
        Random random = new Random();
        // 入队
        for (int i = 0; i < opCount; i++) {
            q.add(random.nextInt(Integer.MAX_VALUE)); // 从0 到int 最大值的随机数
        }

        /*// 出队
        for (int i = 0; i < opCount; i++) {
            q.pop();
        }*/

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }
}
