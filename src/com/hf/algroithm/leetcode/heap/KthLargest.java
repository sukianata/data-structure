package com.hf.algroithm.leetcode.heap;

/**
 * @author: huangfan
 * @date: 2019/3/1 21:29
 */

import java.util.PriorityQueue;

/**
 *
 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

 示例:

 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5
 kthLargest.add(10);  // returns 5
 kthLargest.add(9);   // returns 8
 kthLargest.add(4);   // returns 8
 说明:
 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 */
public class KthLargest {

    private int k=0;

    private PriorityQueue<Integer>  queue;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        queue=new PriorityQueue<>(k);
        for (int i:nums){
            add(i);
        }
    }

    public int add(int val) {
        if (queue.size()<k){
            queue.offer(val);
        }else{
            int temp=queue.poll();
            if (temp<val){
                queue.offer(val);
            }else{
                queue.offer(temp);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}
