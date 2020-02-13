package com.java.review.gather;

public class Node {
    private int order;
    private Object value;
    private Node next;

    public Node() {
    }

    public Node(int order, Object value, Node next) {
        this.order = order;
        this.value = value;
        this.next = next;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "order=" + order +
                ", value=" + value +
                '}';
    }
}
