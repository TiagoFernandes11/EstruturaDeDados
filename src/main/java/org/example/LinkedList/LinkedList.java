package org.example.LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private Integer length;
    public LinkedList(Integer value) {
        makeNewLinkedList(value);
    }
    public void makeNewLinkedList(Integer value){
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }
    public void append(Integer value){
        if(length == 0){
            makeNewLinkedList(value);
            return;
        }
        Node temp = new Node(value);
        this.tail.setNext(temp);
        this.tail = temp;
        length++;
    }
    public void prepend(Integer value){
        Node temp = new Node(value);
        temp.setNext(head);
        this.head = temp;
        length++;
    }
    public Node removeFirst(){
        if(length == 0){
            return null;
        }
        Node temp = this.head;
        this.head = this.head.getNext();
        this.length--;
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
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }
    public Node get(Integer index){
        if(index >= this.length || index < 0){
            System.out.println("Index non existent");
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp;
    }
    public boolean set(Integer index, Integer value){
        Node temp = get(index);
        if(temp == null){
            return false;
        }
        temp.setValue(value);
        return true;
    }
    public boolean insert(Integer index, Integer value){
        if (index < 0 || index > length) return false;
        if(index == 0){
            prepend(value);
            length++;
            return true;
        }
        if(index >= this.length){
            append(value);
            length++;
            return true;
        }
        Node pre = get(index - 1);
        Node pos = get(index);
        Node newNode = new Node(value);

        pre.setNext(newNode);
        newNode.setNext(pos);
        length++;
        return true;
    }
    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.getNext();

        prev.setNext(temp.getNext());
        temp.setNext(null);
        length--;
        return temp;
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
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
}
