package com.hf.algroithm;

/**
 * @author: huangfan
 * @date: 2019/2/25 11:11
 * 已知A,B两个增序数组，将A,B合并成一个增序数组C,该如何操作
 * 参考归并排序的思想
 */
public class MergeArray {

    public static int[] merge(int[] a,int[] b){
        int[] c=new int[a.length+b.length];
        int i=0,j=0,k=0;
        while (i<a.length&&j<b.length){//一个一个元素的比较A,B,小的先放入C,然后小的那个元素所在数组指针后移一位
            if (a[i]<b[j]){
                c[k++]=a[i++];
            }else {
                c[k++]=a[j++];
            }
        }
        //两个数组长度可能不一致，再将另一个数组剩下的元素放入C中
        while (i<a.length){
            c[k++]=a[i++];
        }
        while (j<b.length){
            c[k++]=b[j++];
        }
        return c;
    }

}
