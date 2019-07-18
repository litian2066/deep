package com.dev.devinspringboot.struts.array;
/**
 简单的时间复杂度分析：
 * 大O描述的是算法的运行时间和输入数据之间的关系 分析时 忽略常数
 * T = 2*n + 2          O(n)
 * T = 2000*n + 10000   O(n) 渐进时间复杂度
 * T = 1*n*n + 0        O(n^2) 描述n趋近于无穷的情况
 * addLast(e)       O(1)
 * addFirst(e)      O(n) 在第一个位置插入元素肯定要挪位置 所以是N的复杂度
 * add(index, e)    O(2/n) = O(n) 平均而言要挪动二分之一的元素 所以是N的复杂度
 * removeLast(e) O(1)
 * removeFirst(e) O(n)
 * remove(index, e) O(n)
 * resize() O(n)
 * 修改操作
 * set(index, e) O(1)
 * get(index) O(1)
 * contains(e) O(n)
 * find(e) O(n)
 * 均摊时间复杂度分析：
 *  在增和删除的时候会有扩容的情况出现，然而resize操作是O(n)的复杂度
 *  假设当前capacity = 8， 并且每一次添加操作都使用addLast
 *  在添加第九个元素的时候需要resize操作  所以会有消耗8 + 1 的时间 加上之前添加8次的操作也就是17次基本的操作
 *  9次addLast操作，出发resize 总共进行了17次基本操作
 *  平均下来，每次addLast操作，进行2次基本操作
 *  假设capacity = n， n+ 1次addLast， 出发resize， 总共进行2n+1次基本操作
 *  所以平均下来，每次addLast操作， 进行了2次基本操作
 *  这样平均下来，时间复杂度是O（1） 的
 * 复杂度震荡：
 * removeLast时resize过于着急解决方式是Lazy的处理 等到删除到整个数组的容积的四分之一就可以了
 **/