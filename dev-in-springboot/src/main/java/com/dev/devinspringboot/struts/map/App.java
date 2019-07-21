package com.dev.devinspringboot.struts.map;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        int opCount = 100000;
        Map<Integer, Object> linkedMap = new LinkedListMap<>();
        double v = testMap(linkedMap, opCount);
        System.out.println("linkedMap: " + v + " s");
    }

    /**
     * 测试使用q运行opCount个入栈和出栈的操作所需要的时间, 单位: 秒
     * @param q
     * @param opCount
     * @return
     */
    private static double testMap(Map<Integer, Object> q, int opCount) {
        long startTime = System.nanoTime();

        // ...
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            int i1 = random.nextInt(Integer.MAX_VALUE);
            q.add(i1, i1); // 从0 到int 最大值的随机数
        }


        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }
}
