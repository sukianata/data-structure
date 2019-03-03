package com.hf.algroithm.leetcode.Sort;

/**
 * @author: huangfan
 * @date: 2019/3/1 22:05
 */

import java.util.*;

/**
 *
 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:

 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2]
 示例 2:

 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [9,4]
 说明:

 输出结果中的每个元素一定是唯一的。
 我们可以不考虑输出结果的顺序。
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int len=Math.min(nums1.length,nums2.length);
        int k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set=new HashSet<>();
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                if(!set.contains(nums1[i])){
                    set.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int[] rt=new int[set.size()];
        for (int s:set){
            rt[k++]=s;
        }
        return rt;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int len=Math.min(nums1.length,nums2.length);
        int k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list=new ArrayList<>();
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
               list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] rt=new int[list.size()];
        for (int l:list){
            rt[k++]=l;
        }
        return rt;
    }
}
