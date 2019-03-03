package com.hf.algroithm.leetcode.stack;

import java.util.*;

/**
 * @author: huangfan
 * @date: 2019/3/1 18:20
 */
public class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack=new Stack<>();
    public MinStack() {

    }
    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int min=getMin();
            stack.push(x);
            if (min<x){
                stack.push(min);
            }else{
                stack.push(x);
            }
        }

    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return  stack.get(stack.size()-2);
    }

    public int getMin() {
        return stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
