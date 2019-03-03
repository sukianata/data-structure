package com.hf.algroithm.leetcode.Sort;

/**
 * @author: huangfan
 * @date: 2019/3/2 12:13
 */

/**
 *
 示例 1：

 输入：[-4,-1,0,3,10]
 输出：[0,1,9,16,100]
 示例 2：

 输入：[-7,-3,2,3,11]
 输出：[4,9,9,49,121]


 提示：

 1 <= A.length <= 10000
 -10000 <= A[i] <= 10000
 A 已按非递减顺序排序。
 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
       /*//方法一
        for (int i=0;i<A.length;i++){
            A[i]=A[i]*A[i];
        }
        Arrays.sort(A);
        return A;*/

        /**
         * 方法二
         */
        int i=0;
        int j=A.length-1;
        int[] arr=new int[A.length];
        int k=A.length-1;
        while (i<=j){
            if (A[i]*A[i]<A[j]*A[j]){
                arr[k--]=A[j]*A[j];
                j--;
            }else{
                arr[k--]=A[i]*A[i];
                i++;
            }
        }
        return arr;
    }
}
