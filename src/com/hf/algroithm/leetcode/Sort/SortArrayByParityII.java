package com.hf.algroithm.leetcode.Sort;

/**
 * @author: huangfan
 * @date: 2019/3/1 22:32
 */

/**
 *
 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

 你可以返回任何满足上述条件的数组作为答案。



 示例：

 输入：[4,2,5,7]
 输出：[4,5,2,7]
 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。


 提示：

 2 <= A.length <= 20000
 A.length % 2 == 0
 0 <= A[i] <= 1000

 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        //只要偶数放对位置，奇数自动校正了
        int i=0;//用来寻找偶数
        int j=1;//用来寻找偶数位置
        while (i<A.length&&j<A.length){
            if (A[i]%2!=0){//偶数位置为奇数
                while (A[j]%2!=0){//寻找奇数位置的偶数
                    j+=2;
                }
                //交换两个数位置
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
            }

            i+=2;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{4,2,5,7};
        SortArrayByParityII sortArrayByParityII=new SortArrayByParityII();
        sortArrayByParityII.sortArrayByParityII(nums);
    }
}
