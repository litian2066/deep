package com.dev.devinspringboot.struts.maxHeap;
/*
    优先队列
                    入队                          出队（拿出最大元素）
    普通线性结构      O(1)                          O(N)
    顺序线性结构      O(N)                          O(1)
    堆              O(logN)                       O(logN)
    堆的基本表示：
      二叉堆： Binary Heap
      （二叉堆是一颗完全二叉树[把元素顺序排列成树的形状（就是一层一层的放）]）
      （二叉堆中某个节点的值总是不大于其父节点的值[最大堆， 相应的可以定义最小堆]）
                62
         41             30
    28        16   22        13
 19     17  15
    使用数组表示（从索引1开始）：parent(i) = i / 2 left child(i) = 2*i right child(i) = 2*i + 1
 */