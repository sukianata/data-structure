package com.hf.algroithm.leetcode.array;

/**
 * @author: huangfan
 * @date: 2019/2/28 17:40
 */

/**
 *
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素
 */
public class SearchLocation {
    public int searchInsert(int[] nums, int target) {
        /**
         * 从右到左找第一个比他小的值，放到它的右边,右边的数都往右移动一位
         */
        int i=nums.length-1;
        while (i>=0){
            if (nums[i]==target)
                return i;
            if (nums[i]<target)
               return i+1;
            i--;
        }
        return 0;
    }
}
