package com.dev.devinspringboot.struts.map;

public class BST<K extends Comparable<K>, V> {

    public boolean contains(K k) {
        Node node = getNode(k);
        return node == null;
    }

    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node() {
            this(null, null, null, null);
        }
    }

    public BST() {
        this.root = new Node();
        this.size = 0;
    }

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        }

        return node;
    }

    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("EMPTY!!");
        }
        node.value = value;
    }

    /*public Node get(K key) {
        return get(root, key);
    }*/

    public Node getNode(K key) {
        return get(root, key);
    }

    public V get(K key) {
        Node node = getNode(key);
        return node != null ? node.value : null;
    }

    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public V minimun() {
        Node node = minimun(root);
        return node.value;
    }

    private Node minimun(Node root) {
        if (root.left == null) {
            return root;
        }
        return minimun(root.left);
    }

    public V removeMini() {
        Node node = removeMini(root);
        return node.value;
    }

    /**
     * 删除最小的节点, 返回删除后的以根为节点的树
     * @param node
     * @return
     */
    private Node removeMini(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMini(node.left);
        return node;
    }

    public V remove(K key) {
        Node node = remove(root, key);
        return node.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            return remove(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return remove(node.right, key);
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                size --;
                node.right = null;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                size --;
                node.left = null;
                return leftNode;
            }

            Node sussor = minimun(node.right);
            sussor.right = removeMini(node.right);
            sussor.left = node.left;
            node.left = node.right = null;
            return sussor;
        }
    }

}
