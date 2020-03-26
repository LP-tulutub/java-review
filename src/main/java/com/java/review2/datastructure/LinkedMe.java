package com.java.review2.datastructure;

import com.java.review2.rely.ListNode;
import com.java.review2.rely.PrintLinked;

import java.util.Stack;

public class LinkedMe {
    public static void main(String[] args) {
        LinkedMe linkedMe = new LinkedMe();
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
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    /**
     * Input:
     *      ListNode listNode1C = new ListNode("c1");
     *      listNode1C.next = new ListNode("c2");
     *      listNode1C.next.next = new ListNode("c3");
     * Output: c2----c2----c1
     * Explanation:
     *      C: c1----c2----c3
     *      链表反转
     * condition: 链表反转，O(n)
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
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
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if ((int)l1.value < (int)l2.value) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //答题
        ListNode node = new ListNode(-1);
        ListNode cz = node;
        while (l1 != null || l2 != null){
            if (l1 == null){
                cz.next = l2;
                l2 = null;
            }else if (l2 == null){
                cz.next = l1;
                l1 = null;
            }else if ((int)l1.value <= (int)l2.value){
                cz.next = l1;
                l1 = l1.next;
            }else {
                cz.next = l2;
                l2 = l2.next;
            }
            cz = cz.next;
        }
        return node.next;
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
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.value == head.next.value ? head.next : head;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        //答题
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode gdNode = node;
        while (head.next != null){
            int preVal = (int)head.value;
            head = head.next;
            if ((int)head.value == preVal){
                continue;
            }
            gdNode = gdNode.next;
            gdNode.next = head;
        }
        return node.next;
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
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
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
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;
            pre = pre.next.next;
        }
        return node.next;
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
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }
    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push((int)l.value);
            l = l.next;
        }
        return stack;
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
        if (head == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    
    
}
