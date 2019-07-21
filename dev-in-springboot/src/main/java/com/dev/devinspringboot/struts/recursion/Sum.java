package com.dev.devinspringboot.struts.recursion;

/**
 * 递归求数组的和
 */
public class Sum {

    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[l...n] 这个区间内所有数字的和
    private int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l+1);
    }


}
