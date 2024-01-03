package org.example.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            results.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return results;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.getValue());
                if (currentNode.getLeft() != null) {
                    new Traverse(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    new Traverse(currentNode.getRight());
                }
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.getLeft() != null) {
                    new Traverse(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    new Traverse(currentNode.getRight());
                }
                results.add(currentNode.getValue());
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.getLeft() != null) {
                    new Traverse(currentNode.getLeft());
                }
                results.add(currentNode.getValue());
                if (currentNode.getRight() != null) {
                    new Traverse(currentNode.getRight());
                }
            }
        }
        new Traverse(root);
        return results;
    }
}
