package com.dev.devinspringboot.struts.maxHeap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution2 {

    private static class Freq implements Comparable<Freq> {
        int e, freq;

        @Override
        public int compareTo(Freq o) {
            if (this.freq > o.freq) {
                return 1;
            } else if (this.freq < o.freq) {
                return -1;
            } else {
                return 0;
            }
        }

        /*
          public int compareTo(Freq o) {
            if (this.freq < o.freq) {
                return 1;
            } else if (this.freq > o.freq) {
                return -1;
            } else {
                return 0;
            }
        }
         */

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Freq{" +
                    "e=" + e +
                    ", freq=" + freq +
                    '}';
        }

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (treeMap.containsKey(nums[i])) {
                treeMap.put(nums[i], treeMap.get(nums[i]) + 1);
            } else {
                treeMap.put(nums[i], 0);
            }
        }
        // 使用队列
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int key: treeMap.keySet()) {
            priorityQueue.enqueue(new Freq(key, treeMap.get(key)));
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.dequeue().e);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Freq freq = new Freq(1, 4);
        Freq freq2 = new Freq(3, 2);
        System.out.println(freq2.compareTo(freq));
    }
}
