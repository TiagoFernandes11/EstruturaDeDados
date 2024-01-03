package org.example.linkedlist;

public class Node {
    private Integer value;
    private org.example.linkedlist.Node next;
    public Node(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public org.example.linkedlist.Node getNext() {
        return next;
    }
    public void setNext(org.example.linkedlist.Node next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return this.value + "";
    }
}
