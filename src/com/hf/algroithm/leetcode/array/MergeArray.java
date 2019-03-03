package com.hf.algroithm.leetcode.array;

/**
 * @author: huangfan
 * @date: 2019/2/28 20:12
 */

/**
 *
 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 插入
         */
        int i=m-1;
        int j=0;
        int k=n;
        while (i>=0&&i<nums1.length&&j<n){
            if (nums2[j]<nums1[i]){
                nums1[i+1]=nums1[i];
                i--;
            }else{
                nums1[i+1]=nums2[j];
                k--;
                j++;
                i=m+n-k-1;
            }
        }
        /*int i=0;
        int j=0;
        int k=0;
        int[] nums=new int[m+n];
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]<nums2[j]){
                nums[k++]=nums1[i++];
                continue;
            }
            if (nums2[j]<nums1[i]){
                nums[k++]=nums1[j++];
                continue;
            }
        }
        while (i<nums1.length){
            nums[k++]=nums1[i++];
        }
        while(j<nums2.length){
            nums[k++]=nums2[j++];
        }
        System.arraycopy(nums,0,nums1,0,nums.length);*/
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        new MergeArray().merge(nums1,3,nums2,3);
    }
}
