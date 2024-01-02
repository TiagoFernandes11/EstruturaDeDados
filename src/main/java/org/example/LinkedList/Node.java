package org.example.LinkedList;

public class Node {
    private Integer value;
    private org.example.LinkedList.Node next;
    public Node(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public org.example.LinkedList.Node getNext() {
        return next;
    }
    public void setNext(org.example.LinkedList.Node next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return this.value + "";
    }
}
