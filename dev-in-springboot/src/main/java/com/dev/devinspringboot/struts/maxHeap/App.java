package com.dev.devinspringboot.struts.maxHeap;

import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        /*int n = 100000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test maxHeap completed");*/
        Solution solution = new Solution();
        int[] nums = {1, 4, 6, 7, 7, 9, 3, 10, 7, 11, 10};
        List<Integer> integers = solution.topKFrequent2(nums, 2);
        System.out.println(integers);

    }

}
