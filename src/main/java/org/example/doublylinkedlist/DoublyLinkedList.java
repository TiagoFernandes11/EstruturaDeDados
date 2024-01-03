package org.example.doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private Integer length;

    public DoublyLinkedList(Integer value) {
        makeNewDoublyLinkedList(value);
    }
    public void makeNewDoublyLinkedList(Integer value){
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }
    public void append(Integer value){
        this.tail.setNext(new Node(value));
        this.tail.getNext().setPrev(this.tail);
        this.tail = this.tail.getNext();
        length++;
    }
    public void prepend(Integer value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        head.setPrev(newNode);
        newNode.setNext(head);
        head = newNode;
        length++;
    }
    public Node removeFirst() {
        if(length == 0) return null;
        Node temp = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
            temp.setNext(null);
        }
        length--;
        return temp;
    }
    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.getNext() != null) {
            pre = temp;
            temp = temp.getNext();
        }
        tail = pre;
        tail.setNext(null);
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.getValue());
            System.out.println("Tail: " + tail.getValue());
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    public Node get(Integer index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.setValue(value);
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.getNext();
        newNode.setPrev(before);
        newNode.setNext(after);
        before.setNext(newNode);
        after.setPrev(newNode);
        length++;
        return true;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }
}
