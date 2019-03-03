package com.hf.algroithm.leetcode.array;

/**
 * @author: huangfan
 * @date: 2019/3/1 14:37
 */

/**
 *
 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。

 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。

 返回一个符合上述规则的链表的列表。

 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]

 示例 1：

 输入:
 root = [1, 2, 3], k = 5
 输出: [[1],[2],[3],[],[]]
 解释:
 输入输出各部分都应该是链表，而不是数组。
 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 示例 2：

 输入:
 root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 解释:
 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。


 提示:

 root 的长度范围： [0, 1000].
 输入的每个节点的大小范围：[0, 999].
 k 的取值范围： [1, 50].
 */
public class SplitList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        //获取长度len
        //根据len和k确定分组num，余数必须是1
        //根据num进行拆分
        ListNode cursor=root;

        int len=1;
        while (cursor!=null&&cursor.next!=null){
            cursor=cursor.next;
            len++;
        }
        if(root==null)  len=0;
        int num=k;//分的组数,不会变
        int r=len%num;//余数
        int n=len/num;//每组个数
        ListNode[] result=new ListNode[num];
        int i=1;
        int j=0;
        ListNode head=root;
        cursor=head;
        while (cursor!=null){
            //从头节点开始
            if (r!=0){
                n++;
            }
            while (i<n){
                cursor=cursor.next;
                i++;
            }
            r--;
            n--;
            i=1;
            if (cursor.next==null){
                result[j++]=head;
                cursor=null;
            }else {
                ListNode node=cursor.next;
                cursor.next=null;
                result[j++]=head;
                head=node;
                cursor=node ;
            }
        }

        while (j<num){
            result[j]=null;
            j++;
        }
        return result;
    }
    public static void main(String[] args) {
        SplitList splitList=new SplitList();
        ListNode node1= splitList.new ListNode(1);
        ListNode node2= splitList.new ListNode(2);
        ListNode node3= splitList.new ListNode(3);
        ListNode node4= splitList.new ListNode(4);
      /*  ListNode node5= splitList.new ListNode(5);
        ListNode node6= splitList.new ListNode(6);
        ListNode node7= splitList.new ListNode(7);*/
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
       /* node4.next=node5;
        node5.next=node6;
        node6.next=node7;*/
        splitList.splitListToParts(node1,5);
    }
}
