package com.hf.algroithm.leetcode.array;

/**
 * @author: huangfan
 * @date: 2019/2/28 15:38
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        /**
         * 用快慢两个指针
         */
        int a=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[a])
                nums[++a]=nums[i];
        }
       return a+1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,1,2};
        new RemoveDuplicates().removeDuplicates(nums);
    }
}
