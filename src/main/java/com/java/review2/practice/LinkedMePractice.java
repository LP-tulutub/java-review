package com.java.review2.practice;

import com.java.review2.rely.ListNode;
import com.java.review2.rely.PrintLinked;

import java.util.Stack;

/**
 * 复习情况：3/17 ③ 3/20 ⑦ 3/27 ⑩⑤
 */
public class LinkedMePractice {
    public static void main(String[] args) {
        LinkedMePractice linkedMe = new LinkedMePractice();
        // getIntersectionNode
        ListNode listNode1A = new ListNode("a1");
        ListNode listNode1B = new ListNode("b1");
        listNode1A.next = new ListNode("a2");
        listNode1A.next.next = new ListNode("a3");
        listNode1B.next = new ListNode("b2");
        ListNode listNode1C = new ListNode("c1");
        listNode1C.next = new ListNode("c2");
        listNode1C.next.next = new ListNode("c3");
        listNode1A.next.next.next = listNode1C;
        listNode1B.next.next = listNode1C;
        PrintLinked.printNode(linkedMe.getIntersectionNode(listNode1A, listNode1B), "getIntersectionNode");
        // reverseList
        PrintLinked.printNode(linkedMe.reverseList(listNode1C), "reverseList");
        // mergeTwoLists
        ListNode listNode3A = new ListNode(1);
        listNode3A.next = new ListNode(2);
        listNode3A.next.next = new ListNode(5);
        ListNode listNode3B = new ListNode(1);
        listNode3B.next = new ListNode(3);
        listNode3B.next.next = new ListNode(6);
        PrintLinked.printNode(linkedMe.mergeTwoLists(listNode3A, listNode3B), "mergeTwoLists");
        // deleteDuplicates
        ListNode listNode4A = new ListNode(1);
        listNode4A.next = new ListNode(1);
        listNode4A.next.next = new ListNode(2);
        PrintLinked.printNode(linkedMe.deleteDuplicates(listNode4A), "deleteDuplicates");
        // removeNthFromEnd
        ListNode listNode5A = new ListNode(1);
        listNode5A.next = new ListNode(2);
        listNode5A.next.next = new ListNode(3);
        listNode5A.next.next.next = new ListNode(4);
        listNode5A.next.next.next.next = new ListNode(5);
        PrintLinked.printNode(linkedMe.removeNthFromEnd(listNode5A, 2), "removeNthFromEnd");
        // swapPairs
        ListNode listNode6A = new ListNode(1);
        listNode6A.next = new ListNode(2);
        listNode6A.next.next = new ListNode(3);
        listNode6A.next.next.next = new ListNode(4);
        listNode6A.next.next.next.next = new ListNode(5);
        PrintLinked.printNode(linkedMe.swapPairs(listNode6A), "swapPairs");
        // addTwoNumbers
        ListNode listNode7A = new ListNode(7);
        listNode7A.next = new ListNode(2);
        listNode7A.next.next = new ListNode(4);
        listNode7A.next.next.next = new ListNode(3);
        ListNode listNode7B = new ListNode(5);
        listNode7B.next = new ListNode(6);
        listNode7B.next.next = new ListNode(4);
        PrintLinked.printNode(linkedMe.addTwoNumbers(listNode7A, listNode7B), "addTwoNumbers");
        // oddEvenList
        ListNode listNode10A = new ListNode(1);
        listNode10A.next = new ListNode(2);
        listNode10A.next.next = new ListNode(3);
        listNode10A.next.next.next = new ListNode(4);
        listNode10A.next.next.next.next = new ListNode(5);
        PrintLinked.printNode(linkedMe.oddEvenList(listNode10A), "oddEvenList");

    }

    /**
     * Input:
     *      ListNode listNode1A = new ListNode("a1");
     *      ListNode listNode1B = new ListNode("b1");
     *      listNode1A.next = new ListNode("a2");
     *      listNode1A.next.next = new ListNode("a3");
     *      listNode1B.next = new ListNode("b2");
     *      ListNode listNode1C = new ListNode("c1");
     *      listNode1C.next = new ListNode("c2");
     *      listNode1C.next.next = new ListNode("c3");
     *      listNode1A.next.next.next = listNode1C;
     *      listNode1B.next.next = listNode1C;
     * Output: c1----c2----c3
     * Explanation:
     *      A: a1----a2----a3----c1----c2----c3
     *      B: b1----b2----c1----c2----c3
     *      当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B
     *      同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A
     *      这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点
     * condition: 找出两个链表的交点，O(n)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      ListNode listNode1C = new ListNode("c1");
     *      listNode1C.next = new ListNode("c2");
     *      listNode1C.next.next = new ListNode("c3");
     * Output: c3----c2----c1
     * Explanation:
     *      C: c1----c2----c3
     *      链表反转
     * condition: 链表反转，O(n)
     */
    public ListNode reverseList(ListNode head) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      ListNode listNode3A = new ListNode(1);
     *      listNode3A.next = new ListNode(2);
     *      listNode3A.next.next = new ListNode(5);
     *      ListNode listNode3B = new ListNode(1);
     *      listNode3B.next = new ListNode(3);
     *      listNode3B.next.next = new ListNode(6);
     * Output: 1----1----2----3----5----6
     * Explanation:
     *      A: 1----2----5
     *      B: 1----3----6
     *      归并两个有序的链表
     * condition: 归并两个有序的链表，O(n)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      ListNode listNode4A = new ListNode(1);
     *      listNode4A.next = new ListNode(1);
     *      listNode4A.next.next = new ListNode(2);
     * Output: 1----2
     * Explanation:
     *      A: 1----1----2
     *      从有序链表中删除重复节点
     * condition: 从有序链表中删除重复节点，O(n)
     */
    public ListNode deleteDuplicates(ListNode head) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      ListNode listNode5A = new ListNode(1);
     *      listNode5A.next = new ListNode(2);
     *      listNode5A.next.next = new ListNode(3);
     *      listNode5A.next.next.next = new ListNode(4);
     *      listNode5A.next.next.next.next = new ListNode(5);
     * Output: 1----2----3----5
     * Explanation:
     *      A: 1----2----3----4----5
     *      删除链表的倒数第 n 个节点
     * condition: 删除链表的倒数第 n 个节点，O(n)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      ListNode listNode6A = new ListNode(1);
     *      listNode6A.next = new ListNode(2);
     *      listNode6A.next.next = new ListNode(3);
     *      listNode6A.next.next.next = new ListNode(4);
     *      listNode6A.next.next.next.next = new ListNode(5);
     * Output: 2----1----4----3----5
     * Explanation:
     *      A: 1----2----3----4----5
     *      交换链表中的相邻结点
     * condition: 交换链表中的相邻结点，O(n)，O(1)空间复杂度
     */
    public ListNode swapPairs(ListNode head) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      ListNode listNode7A = new ListNode(7);
     *      listNode7A.next = new ListNode(2);
     *      listNode7A.next.next = new ListNode(4);
     *      listNode7A.next.next.next = new ListNode(3);
     *      ListNode listNode7B = new ListNode(5);
     *      listNode7B.next = new ListNode(6);
     *      listNode7B.next.next = new ListNode(4);
     * Output: 7----8----0----7
     * Explanation:
     *      A: 7----2----4----3
     *      B: 5----6----4
     *      链表求和
     * condition: 链表求和，O(n)，不能修改原始链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //答题

        return null;//null
    }
    private Stack<Integer> buildStack(ListNode l) {
        //答题

        return null;//null
    }

    /**
     * Input:
     *      ListNode listNode10A = new ListNode(1);
     *      listNode10A.next = new ListNode(2);
     *      listNode10A.next.next = new ListNode(3);
     *      listNode10A.next.next.next = new ListNode(4);
     *      listNode10A.next.next.next.next = new ListNode(5);
     * Output: 1----3----5----2----4
     * Explanation:
     *      A: 1----2----3----4----5
     *      链表元素按奇偶聚集
     * condition: 链表元素按奇偶聚集，O(n)
     */
    public ListNode oddEvenList(ListNode head) {
        //答题

        return null;//null
    }
}
