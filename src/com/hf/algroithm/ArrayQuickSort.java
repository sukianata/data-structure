package com.hf.algroithm;

/**
 * @author: huangfan
 * @date: 2019/2/26 13:02
 * 单链表快排
 */
public class ArrayQuickSort {
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }

    public void quickSort(Node begin,Node end){
        Node p=begin;
        Node q=begin.next;
        int midValue=begin.value;
        while (q!=end.next&&q!=null){
            if (q.value<midValue){
                p=p.next;
                if (p!=q){
                    int temp=p.value;
                    p.value=q.value;
                    q.value=temp;
                }
            }
            q=q.next;
        }
        if (begin!=p){
            int temp=begin.value;
            begin.value=p.value;
            p.value=temp;
        }
        quickSort(begin,p);
        quickSort(p.next,end);

    }
}
