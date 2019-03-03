package com.hf.algroithm.leetcode.array;

/**
 * @author: huangfan
 * @date: 2019/2/28 19:27
 */

/**
 *
 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        /**
         * 从最后一位开始加 考虑为9的时候 ，以及最大位进一的时候
         */
        int[] newArr=new int[digits.length+1];
        int k=digits.length-1;
        while (k>=0){
            if (digits[k]==9){
                if (k==0){
                    newArr[0]++;
                }
                digits[k]=0;
                k--;
            }else{
                digits[k]++;
                break;
            }
        }
        if (newArr[0]!=0){
            System.arraycopy(digits, 0, newArr, 1, digits.length);
            return newArr;
        }
        return digits;
    }
}
