package com.java.review2.datastructure;

import com.java.review2.rely.PrintArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueMe {
    public static void main(String[] args) {
        StackQueueMe sm = new StackQueueMe();
        // 用栈实现队列MyQueue
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.print("用栈实现队列MyQueue: ");
        while (!myQueue.empty()){
            System.out.print(myQueue.pop() + " ");
        }
        System.out.println();
        // 用队列实现栈MyStack
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.print("用队列实现栈MyStack: ");
        while (!myStack.empty()){
            System.out.print(myStack.pop() + " ");
        }
        System.out.println();
        // 最小值栈MinStack
        MinStack minStack = new MinStack();
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
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cStack = stack.pop();
                boolean b1 = c == ')' && cStack != '(';
                boolean b2 = c == ']' && cStack != '[';
                boolean b3 = c == '}' && cStack != '{';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
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
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }
        return dist;
    }

    /**
     * Input:
     *      nums = {1,2,1,3}
     * Output: [2,3,3,-1]
     * Explanation:
     *      循环数组中比当前元素大的下一个元素
     * condition: 循环数组中比当前元素大的下一个元素，用栈实现
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> pre = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!pre.isEmpty() && nums[pre.peek()] < num) {
                next[pre.pop()] = num;
            }
            if (i < n){
                pre.push(i);
            }
        }
        return next;
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
class MyQueue {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        in2out();
        return out.pop();
    }

    public int peek() {
        in2out();
        return out.peek();
    }

    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
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
class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.add(x);
        min = Math.min(min, x);
        minStack.add(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

