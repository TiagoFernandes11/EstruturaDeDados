package org.example.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void enqueue(Integer value){
        Node node = new Node(value);
        if(length == 0){
            last = node;
            first = node;
        }
        last.setNext(node);
        last = node;
        length++;
    }

    public Node dequeue(){
        if(length == 0) return null;
        Node temp = first;
        if(length == 1) {
            first = null;
            length--;
            return temp;
        }
        first = first.getNext();
        length--;
        return temp;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.getValue());
            System.out.println("Last: " + last.getValue());
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }
}
