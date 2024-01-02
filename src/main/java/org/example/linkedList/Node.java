package org.example.linkedList;

public class Node {
    private Integer value;
    private org.example.linkedList.Node next;
    public Node(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public org.example.linkedList.Node getNext() {
        return next;
    }
    public void setNext(org.example.linkedList.Node next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return this.value + "";
    }
}
