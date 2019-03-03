package com.hf.algroithm.leetcode.array;

/**
 * @author: huangfan
 * @date: 2019/3/1 10:29
 */

/**
 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]
 示例 2:

 输入: [-1,-100,3,99] 和 k = 2
 输出: [3,99,-1,-100]
 解释:
 向右旋转 1 步: [99,-1,-100,3]
 向右旋转 2 步: [3,99,-1,-100]
 说明:

 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k %=len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);

    }
    private void  reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start++]=nums[end];
            nums[end--]=temp;
        }
    }


//      Definition for singly-linked list.
     class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode rotateRight(ListNode head, int k) {
        //构造连环
        if (head==null||k==0) return head;
        int len=1;
        ListNode node=head;
        while(node.next!=null){
            node=node.next;
            len++;
        }
        node.next=head;
        node=head;
        //断开连环
        int i=0;
        k=len-(k%len);//这个公式是重点
        while(i<k){
            if (i==k-1){
                node=head.next;
                head.next=null;
            }else{
                head=head.next;
            }
            i++;
        }
        return node;
    }
    private ListNode reverse2(ListNode head){
        int i=0;
        int j=0;
        if (head.next==null||head==null){
            return head;
        }
        ListNode node=reverse2(head.next);
        node.next=head;
        head.next=null;
        return head;
    }
    public static void main(String[] args) {

//        int[] nums=new int[]{1,2,3,4,5,6,7};

        /*int[] nums=new int[]{-1,-100,3,99};
        new Rotate().rotate(nums,2);*/
        Rotate rotate=new Rotate();
        ListNode node1= rotate.new ListNode(1);
        ListNode node2= rotate.new ListNode(2);
        ListNode node3= rotate.new ListNode(3);
        ListNode node4= rotate.new ListNode(4);
        ListNode node5= rotate.new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode node=rotate.rotateRight(node1,2);
        System.out.println(node);

    }
}
