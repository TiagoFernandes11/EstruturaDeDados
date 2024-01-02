package org.example.stack;

public class Stack {
    private Node top;
    private Integer height;

    public Stack() {
        this.top = null;
        this.height = 0;
    }

    public Stack(Integer value) {
        this.top = new Node(value);
        this.height = 1;
    }

    public void push(Integer value){
        Node newNode = new Node(value);
        if(height == 0){
            this.top = newNode;
            this.height++;
            return;
        }
        newNode.setNext(top);
        top = newNode;
        this.height++;
    }

    public Node pop(){
        if(this.top == null){
            return null;
        }
        Node temp = top;
        top = top.getNext();
        height--;
        return temp;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.getValue());
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public Node getTop() {
        return top;
    }

    public Integer getHeight() {
        return height;
    }
}
