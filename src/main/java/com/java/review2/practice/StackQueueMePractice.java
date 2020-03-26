package com.java.review2.practice;


import com.java.review2.rely.PrintArray;

import java.util.*;

/**
 * 复习情况：3/11 ③ 3/14 ⑦ 3/21 ⑦
 */
public class StackQueueMePractice {
    public static void main(String[] args) {
        StackQueueMePractice sm = new StackQueueMePractice();
        // 用栈实现队列MyQueue
        MyQueueP myQueue = new MyQueueP();
        myQueue.push(1);
        myQueue.push(2);
        System.out.print("用栈实现队列MyQueue: ");
        while (!myQueue.empty()){
            System.out.print(myQueue.pop() + " ");
        }
        System.out.println();
        // 用队列实现栈MyStack
        MyStackP myStack = new MyStackP();
        myStack.push(1);
        myStack.push(2);
        System.out.print("用队列实现栈MyStack: ");
        while (!myStack.empty()){
            System.out.print(myStack.pop() + " ");
        }
        System.out.println();
        // 最小值栈MinStack
        MinStackP minStack = new MinStackP();
        minStack.push(1);
        minStack.push(2);
        System.out.println("最小值栈MinStack: " + minStack.getMin());
        // isValid
        System.out.println("isValid: " + sm.isValid("()[]{}"));
        // dailyTemperatures
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        PrintArray.printInt(sm.dailyTemperatures(temperatures), "dailyTemperatures");
        // nextGreaterElements
        int[] nums = {1,2,1,3};
        PrintArray.printInt(sm.nextGreaterElements(nums), "nextGreaterElements");
    }

    /**
     * Input:
     *      s = "()[]{}"
     * Output: true
     * Explanation:
     *      匹配()[]{}，必须连续，中间不能有内容
     * condition: 用栈实现括号匹配，用栈实现
     */
    public boolean isValid(String s) {
        //答题

        return false;//false
    }

    /**
     * Input:
     *      temperatures = {73, 74, 75, 71, 69, 72, 76, 73}
     * Output: [1, 1, 4, 2, 1, 1, 0, 0]
     * Explanation:
     *      数组中元素与下一个比它大的元素之间的距离
     * condition: 数组中元素与下一个比它大的元素之间的距离，用栈实现
     */
    public int[] dailyTemperatures(int[] temperatures) {
        //答题

        return null;//null
    }

    /**break
     * Input:
     *      nums = {1,2,1,3}
     * Output: [2,3,2,-1]
     * Explanation:
     *      循环数组中比当前元素大的下一个元素
     * condition: 循环数组中比当前元素大的下一个元素，用栈实现
     */
    public int[] nextGreaterElements(int[] nums) {
        //答题

        return null;//null
    }

}

/**
 * Explanation:
 *      1.插入数据
 *      2.取出数据，删除
 *      3.取出数据，保留
 *      4.判断是否是空的
 * condition: 用栈实现队列
 */
class MyQueueP {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {

    }

    public int pop() {

        return -1;
    }

    public int peek() {

        return -1;
    }

    private void in2out() {

    }

    public boolean empty() {
        return true;
    }
}

/**
 * Explanation:
 *      1.插入数据
 *      2.取出数据，删除
 *      3.取出数据，保留
 *      4.判断是否是空的
 * condition: 用队列实现栈
 */
class MyStackP {
    private Queue<Integer> queue;

    public MyStackP() {

    }

    public void push(int x) {

    }

    public int pop() {

        return -1;
    }

    public int top() {
        return -1;
    }

    public boolean empty() {
        return true;
    }
}

/**
 * Explanation:
 *      1.插入数据
 *      2.取出数据，删除
 *      3.取出数据，保留
 *      4.得到最小值
 * condition: 最小值栈
 */
class MinStackP {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    public MinStackP() {

    }

    public void push(int x) {

    }

    public void pop() {

    }

    public int top() {
        return -1;
    }

    public int getMin() {
        return -1;
    }
}




