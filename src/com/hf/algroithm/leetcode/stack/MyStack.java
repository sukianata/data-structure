package com.hf.algroithm.leetcode.stack;

/**
 * @author: huangfan
 * @date: 2019/3/1 19:06
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 使用队列实现栈的下列操作：

 push(x) -- 元素 x 入栈
 pop() -- 移除栈顶元素
 top() -- 获取栈顶元素
 empty() -- 返回栈是否为空
 注意:

 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
public class MyStack {
    /** Initialize your data structure here. */
    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();

    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
      queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue1.size()==1) {
            return queue1.poll();
        }else {
            while(queue1.size()!=1) {
                queue2.add(queue1.poll());
            }
            int temp= queue1.poll();
            while(!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            return temp;
        }
    }

    /** Get the top element. */
    public int top() {
        while (queue1.size()!=1){
            queue2.add(queue1.poll());
        }
        int temp=queue1.poll();
        queue2.offer(temp);
        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
