package org.example.binarysearchtree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
    }
    public BinarySearchTree(Integer value) {
        this.root = new Node(value);

    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.getValue() == temp.getValue()) return false;
            if (newNode.getValue() < temp.getValue()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return true;
                }
                temp = temp.getLeft();
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(newNode);
                    return true;
                }
                temp = temp.getRight();
            }
        }
    }

    public boolean contains(Integer value){
        Node node = new Node(value);
        Node temp = root;
        while(true){
            if(temp == null) return false;
            if(temp.getValue() == node.getValue()) return true;
            if(node.getValue() < temp.getValue()){
                temp = temp.getLeft();
            }else {
                temp = temp.getRight();
            }
        }
    }
}
