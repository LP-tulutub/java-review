package com.java.review.gather;

public class OrderNodeLink {

    protected Node first;
    protected int length;


    public OrderNodeLink() {
        this.first = null;
        this.length = 0;
    }

    // 查看头结点是否为空
    public boolean isEmpty() {
        return first==null;
    }

    // 在链表中插入一个结点，保持链表有序性
    public void insertNode(int order, Object value){
        Node newNode = new Node(order, value, null);
        Node previous = null; //上一个节点
        Node currentLink = first; // 当前节点
        //当前链接点不为空,且新链接点大于当前链接点.当前链接点往后挪一个结点
        while(currentLink!=null && order>=currentLink.getOrder()) {
            previous = currentLink;
            currentLink = currentLink.getNext();
        }
        //插入
        if (previous == null){
            first = newNode;
        }else {
            previous.setNext(newNode);
        }
        newNode.setNext(currentLink);
        length+= 1;
    }
    // 返回头结点
    public Node getHeader(){
        return first;
    }
    // 删除头结点，并删除
    public void del(){
        first = null;
        length = 0;
    }
    // 删除指定结点
    // 遍历有序链表
    public void displayList() {
        Node current = first;
        while(current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }
}
