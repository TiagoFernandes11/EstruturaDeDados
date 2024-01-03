package org.example.recursive.rbinarysearchtree;

public class RecursiveBinarySearchTree {
    private Node root;

    public RecursiveBinarySearchTree() {
    }
    public RecursiveBinarySearchTree(Integer value) {
        this.root = new Node(value);

    }

    public boolean Contains(Integer value){
        return Contains(root, value);
    }

    private boolean Contains(Node currentNode, Integer value){
        if(currentNode == null) return false;
        if(currentNode.getValue() == value) return true;
        if(value < currentNode.getValue()) return Contains(currentNode.getLeft(), value);
        else return Contains(currentNode.getRight(), value);
    }

    public void Insert(int value) {
        if (root == null) root = new Node(value);
        Insert(root, value);
    }

    private Node Insert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.getValue()) {
            currentNode.setLeft(Insert(currentNode.getLeft(), value));
        } else if (value > currentNode.getValue()) {
            currentNode.setRight(Insert(currentNode.getRight(), value));
        }
        return currentNode;
    }
}
