package com.dev.devinspringboot.struts.maxHeap;

import java.util.*;
import java.util.PriorityQueue;

public class Solution {

    private class Freq/* implements Comparable<Freq> */{
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        /**
         * 优先级队列里面容易取出频次最低的数所以
         * 频次最低的优先级最高
         * @return
         */
        /*@Override
        public int compareTo(Freq o) {
            if (this.freq < o.freq) {
                return -1;
            } else if (this.freq > o.freq) {
                return 1;
            } else {
                return 0;
            }
        }
        */
        @Override
        public String toString() {
            return "Freq{" +
                    "e=" + e +
                    ", freq=" + freq +
                    '}';
        }
    }

    // 创建Freq类的比较器
    private class FreqCompator implements Comparator<Freq> {


        @Override
        public int compare(Freq a, Freq b) {
            System.out.println(a.e + "----  " + (b.freq - a.freq));
            return b.freq - a.freq;
            /*if (a.freq < b.freq) {
                return 1;
            } else if (a.freq > b.freq) {
                return -1;
            } else {
                return 0;
            }*/
        }
    }

    /**
     * 返回数组中元素出现频次最高的k个元素list
     * Ologn（K）的复杂度
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
         TreeMap<Integer, Integer> map = new TreeMap<>();
         for (int num: nums) {
             if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
             } else {
                map.put(num, 0);
             }
         }
         PriorityQueue<Freq> priorityQueue = new PriorityQueue<>(new FreqCompator());
         for (int key: map.keySet()) {
//             System.out.println(key + " " + map.get(key) + " peek: " + (!priorityQueue.isEmpty() ? priorityQueue.peek().freq : ""));
             /*if (priorityQueue.size() < k) {
                 priorityQueue.add(new Freq(key, map.get(key)));
             } else if (map.get(key) > priorityQueue.peek().freq){
                 priorityQueue.remove();
                 priorityQueue.add(new Freq(key, map.get(key)));
             }*/
             /*if (!priorityQueue.isEmpty()) {

             }*/
             priorityQueue.add(new Freq(key, map.get(key)));
         }
        // System.out.println(priorityQueue);
         List<Integer> res = new LinkedList<>();
         /*while (!priorityQueue.isEmpty()) {
             res.add(priorityQueue.remove().e);
         }*/
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.remove().e);
        }
         return res;
     }


    public List<Integer> topKFrequent2(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 0);
            }
        }
        /*PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });*/
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>( (o1, o2) -> map.get(o2) - map.get(o1));
        for (int key: map.keySet()) {
//             System.out.println(key + " " + map.get(key) + " peek: " + (!priorityQueue.isEmpty() ? priorityQueue.peek().freq : ""));
             /*if (priorityQueue.size() < k) {
                 priorityQueue.add(new Freq(key, map.get(key)));
             } else if (map.get(key) > priorityQueue.peek().freq){
                 priorityQueue.remove();
                 priorityQueue.add(new Freq(key, map.get(key)));
             }*/
             /*if (!priorityQueue.isEmpty()) {

             }*/
            priorityQueue.add(key);
        }
        // System.out.println(priorityQueue);
        List<Integer> res = new LinkedList<>();
         /*while (!priorityQueue.isEmpty()) {
             res.add(priorityQueue.remove().e);
         }*/
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.remove());
        }
        return res;
    }

}
