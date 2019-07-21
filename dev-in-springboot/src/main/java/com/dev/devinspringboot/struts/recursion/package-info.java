package com.dev.devinspringboot.struts.recursion;
/**
    本质上, 将原来的问题, 转化为更小的问题
    比如数组求和:
        sum(arr[0....100]) = arr[0] + sum(arr[1...100])
    将原问题变成一个更小的问题/一个最基本的问题再进行求解
    链表具有天然的递归性
 比如: 0 -> 1 -> 2 -> 3 == 0 -> [1 -> 2 -> 3](一个更短的链表, 少了一个节点)
    递归的微观语义:
        其实是一个子过程的调用, 顺序执行 一定要先把子过程跑完 再跑上一个过程
 **/