package com.dev.devinspringboot.struts.efsss;
/*
    二叉树是动态数据结构
    二叉树具有唯一根节点
    class Node {
        E e;
        Node left; // 左孩子
        Node right; // 右孩子
    }
    二叉树每个节点最多有两个孩子
    一个孩子都没有的是叶子节点
    二叉树每个节点最多有一个父亲节点
    和链表一样具有天然的递归结构
        * 每个节点的左子树也是二叉树
        * 每个节点的右子树也是二叉树
    二叉树不一定是满的
    二分搜索树:
        * 二分搜索树是二叉树
        * 二分搜索树的每个节点的值:
            大于其左子树的所有节点的值
            小于其右子树的所有节点的值
        * 每一棵子树也是一个二分搜索树
    集合:
        不能盛放重复元素
        二分搜索树非常好的实现"集合"的底层数据结构
    前序遍历:
        访问节点
        traverse(node.left)
        traverse(node.right)
        // 非递归写法: 采用java的栈来实现采用一棵树一棵树的压栈和出栈的操作来实现
        stack.push(root)
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            sout(node.e);
            // 因为栈是LIFO结构 所以右子树先进栈
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    中序遍历:
        traverse(node.left)
        访问节点
        traverse(node.right)
        结果有序(很有意思的现象)
    后序遍历
        traverse(node.left)
        traverse(node.right)
        访问节点
        应用: 后序遍历为二分搜索树释放内存 ,先处理左子树 再处理右子树
        然后处理父节点
    广度优先遍历:
            * 层序遍历
                * BST采用的是队列来实现层序遍历
                * 一层一层的入队和出队来实现
                while(!queue.isEmpty()) {
                    Node node = queue.remove();
                    sout(node.e)
                    if (node.left != null) {
                        queue.enqueue(node.left);
                    }
                    if (node.right != null) {
                        queue.enqueue(node.right);
                    }

                }
        更快的找到问题的解(比如问题的解刚好在右子树的第二层 这时使用深度可能要花些时间)
        常用于算法设计中--最短路径
        图中的深度优先遍历和广度优先遍历
     求两个数组的交集:
        比如 num1[] =  {1, 2, 2, 1} nums2[] = {2, 2} 返回[2]
        使用treeSet来实现
     求两个数组的交集2:
        比如 num1[] =  {1, 2, 2, 1} nums2[] = {2, 2} 返回[2, 2]
        使用映射来实现
     查找二分搜索树的最小元素
     public E minimun() {
        if (size == 0) {
            throw new IllegalAr....
        }
        Node minNode = mininum(root);
        return miniNode.e;
     }
     // 返回以node为根的二分搜索树的最小值所在的节点
     // 查找左子树
     public Node minimun(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimun(node.left);
     }
     * 同理查找二分树的最大元素
     public E maxmun() {
        if (size == 0) {
            throw new IllegalAr....
        }
        Node minNode = mininum(root);
        return miniNode.e;
     }
     // 返回以node为根的二分搜索树的最大值所在的节点
     // 查找左子树
     public Node maxmun(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmun(node.left);
     }
     * 从二分搜索树中删除最小值所在的节点, 返回最小值
     public E removeMin() {
        E ret = mininum();
        root = removeMin(root);
        return ret;
     }


     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     public Node removeMin(Node node) {
        // 处理递归到底的情况
        if (node.left == null) {
            Node retNode = node.right;
            node.right = null;
            size -- ;
            return retNode;
        }
        return removeMin(node.left);

     }

     * 同理 删除最大节点
     public E removeMax() {
        E ret = maxmum();
        root = removeMax(root);
        return ret;
     }

     public Node removeMax(Node node) {
        if (node.right == null) {
            Node retNode = node.left;
            node.left = null;
            size --;
            return retNode;
        }
        return removeMax(node.right);
     }

     * 删除二分搜索树中的任意节点
       如果节点没有左孩子或者右孩子 那么删除方法和删除最大和最小类似
       如果左右孩子都有的话需要找到该节点的后继或者前驱来替代
       后继即为右孩子中最小的节点
       前驱即为左孩子中最大的节点

       public Node remove(Node node, E e) {
            if (node == null) {
                return null;
            }

            if (e.compareTo(node.e) < 0) {
                return remove(Node.left, e);
            } else if (e.compareTo(node.e) > 0) {
                return remove(Node.right, e);
            } else {
                if (node.left == null && node.right != null) {
                    Node ret = node.right;
                    node.right = null;
                    size --;
                    return ret;

                } else if (node.left != null && node.right == null) {
                    Node ret = node.left;
                    node.left = null;
                    size --;
                    return ret;

                } else {
                    // 找到后继节点
                    Node surrsor = minimun(node.right);
                    surrsor.left = node.left;
                    surrsor.right = removeMin(node.right);
                    node.left = node.right = null;
                    return surrsor;
                }
            }


       }

      复杂度分析:
        底层是链表的LinkedListSet 在添加的实现中为了保证不重复 要先查询一便是否有重复元素所以是O(N) 查询
        也是O(N); 删除也是O(N) 都需要扫描一遍
        BSTSet:
            类似于二分查找方法, 一层一层下去 每次几乎可以把一般的节点排除掉
            所以复杂度是O(h) h是树的高度
            分析:
                极端情况下(左右孩子都有):
                0层: 1 个节点
                1层: 2 个节点
                2层: 4 个节点
                3层: 8 个节点
                ... -> 2^(h-1)的节点
                一共有多少个节点:
                    2^0 + 2^1 + 2^2 + ... + 2^h-1
                        (等比数列)
                        => (1*(1-2^h)) / 1-2 => 2^h -1 = N
                        所以h = log2(n + 1)
                        => O(log2n) => O(logn)

            那么logn和n是什么概念么:
                        logn    n
            n = 16 =>   4       16   -四倍
            n = 1024 => 10      1024  100倍
            n = 100万 => 20      100万  5万倍
            但是二分搜索树最差的时候和链表一样
 */
