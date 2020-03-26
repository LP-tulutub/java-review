package com.java.review2.rely;

public class PrintLinked {
    public static void printNode(ListNode listNode, String name){
        if (listNode == null){
            System.out.println(name + ": null");
            return;
        }
        ListNode pointer1 = listNode, pointer2 = listNode.next;
        while (pointer2 != null && pointer2.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
            if (pointer1 == pointer2){
                System.err.println(name + ": 环状链表 ");
                return;
            }
        }
        System.out.print(name + ": ");
        ListNode node = listNode;
        while (node != null){
            System.out.print(node.value);
            node = node.next;
            if (node != null) System.out.print("----");
        }
        System.out.println();
    }
}
