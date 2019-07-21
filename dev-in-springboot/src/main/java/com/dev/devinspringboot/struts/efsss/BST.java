package com.dev.devinspringboot.struts.efsss;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    public Node add(Node node, E e) {
        if (node == null) {
            size ++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            return add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return add(node.right, e);
        }
        return node;
    }

    /**
     * 向二分搜索树中添加新的元素
     *
     * @param e
     */
    public void add2(E e) {
        if (root == null) {
            root = new Node(e);
            size ++;
        } else {
            add2(root, e);
        }
    }

    public void add2(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        }

        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size ++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size ++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add2(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            add2(node.right, e);
        }
    }

    /**
     * 是否包含
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) == 0) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }


    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }
    // 前序遍历的非递归实现
    // 采用堆栈的方式,一层一层的压栈和出栈
    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.e);
            if (pop.right != null) {
                stack.push(pop.right);
            } else if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    // 后序遍历
    public void afterOrder() {
        afterOrder(root);
    }

    private void afterOrder(Node node) {
        if (node == null) {
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.e);
    }


//    public E get(E e) {
//        return get(root, e);
//    }
//
//    private E get(Node node, E e) {
//        if (isEmpty()) {
//            throw new IllegalArgumentException("Tree is empty");
//        }
//        if (e.equals(node.e)) {
//            return node.e;
//        }
//    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    /**
     * BTS的层序遍历
     */
    public void  levelOrder() {
        levelOrder(root);
    }

    /**
     * 层序遍历 顾名思义 一层一层的遍历 可以采用队列的形式来进行遍历
     * 一层一层的入队和出队来进行遍历
     * @param root
     */
    private void levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.e);
            if (node.left != null) {
                q.add(node.left);
            } else if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    /**
     * 查找二分搜索树的最小元素
     * @return
     */
    public E minimum() {
        if (size == 0) {
            return null;
        }
        Node miniNode = minimum(root);
        return miniNode.e;
    }

    private Node minimum(Node root) {
        if (root.left == null) {
            return root;
        }

        return minimum(root.left);
    }


    /**
     * 查找二分搜索树的最小元素
     * @return
     */
    public E maxmum() {
        if (size == 0) {
            return null;
        }
        Node miniNode = maxmum(root);
        return miniNode.e;
    }

    private Node maxmum(Node root) {
        if (root.right == null) {
            return root;
        }

        return maxmum(root.right);
    }

    // 从二分搜索树中删除最小节点, 返回删除后的以根节点
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * @Link
     * @return 删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        // 处理递归到底的情况
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
// 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public Node remove(E e) {
        return remove(root, e);
    }

    private Node remove(Node node, E e) {

        if (node == null ) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            return remove(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return remove(node.right, e);
        } else {
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树都有的情况 需要找到前驱节点(左子树最大)后者后继节点(右子树最小)
            Node surror = minimum(node.right);
            surror.right = removeMin(node.right);
            surror.left = node.left;
            node.left = node.right = null;
            return surror;

        }




    }

}
