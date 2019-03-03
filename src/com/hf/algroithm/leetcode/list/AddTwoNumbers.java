package com.hf.algroithm.leetcode.list;

/**
 * @author: huangfan
 * @date: 2019/3/2 11:15
 */

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 从低位开始加
         * 两个指针i,j同步进行
         * 若产生进位 需要做拆分，分出10位和个位
         *      k表示个位数
         *      n表示进位数 1 or 0
         *      num1 num2表示两个家数
         *      sum=num1+num2+k;
         *      sum>10?
         *          while(sum!=10)
         *              sum--;
         *              k++;
         *     sum<10
         *          new Node(sum);
         *          k=0;
         *     sum==10
         *          k=0;n=1;
         *
         */
        ListNode node1=l1;
        ListNode node2=l2;
        ListNode cursor=new ListNode(0);
        ListNode rt=cursor;
        int k=0;//表示要存储到新节点的值
        int n=0;
        while (node1!=null||node2!=null){
            int x=(node1==null)?0:node1.val;
            int y=(node2==null)?0:node2.val;
            int sum=x+y+n;
            k=sum%10;
            n=sum/10;
            ListNode node=new ListNode(k);
            cursor.next=node;
            cursor=node;
            if (node1!=null){
                node1=node1.next;
            }
            if (node2!=null){
                node2=node2.next;
            }
        }
        if (n!=0){
            ListNode node=new ListNode(n);
            cursor.next=node;
        }
        return rt.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers numbers=new AddTwoNumbers();
        ListNode node1=numbers.new ListNode(9);
        ListNode node2=numbers.new ListNode(9);
        ListNode node3=numbers.new ListNode(9);
        ListNode node4=numbers.new ListNode(9);
        node1.next=node2;
        node3.next=node4;
        numbers.addTwoNumbers(node1,node3);

    }
}
