package com.hf.algroithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huangfan
 * @date: 2019/2/28 15:10
 *  leetcode1
 *
 */
public class TwoSum {
    /**
     *
     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
       你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
       示例:
       给定 nums = [2, 7, 11, 15], target = 9
       因为 nums[0] + nums[1] = 2 + 7 = 9
       所以返回 [0, 1]
     */

    /**
     * 最先想到的方法是暴力列舉,听说可以用hashmap
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map=new HashMap();
        int [] rt=new int[2];
        for (int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if (map.containsKey(temp)&&map.get(temp)!=i){
                rt[0]=i;
                rt[1]=map.get(temp);
            }
            map.put(nums[i],i);//把值作为key,下标作为value
        }


        return null;
    }

    /**
     *
     给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

     函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

     说明:

     返回的下标值（index1 和 index2）不是从零开始的。
     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     示例:

     输入: numbers = [2, 7, 11, 15], target = 9
     输出: [1,2]
     解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * @param numbers
     * @param target
     * @return
     */
    //[-3,3,4,90] 0
    //[-1,0] -1
    public int[] twoSum2(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        int[] rt=new int[2];
        while (left<right){
            if (numbers[left]+numbers[right]==target){
                rt[0]=left+1;
                rt[1]=right+1;
                break;
            }
            if (numbers[left]+numbers[right]<target){
                left++;
            }else {
                right--;
            }
        }
        return rt;
        /*int i=numbers.length-1;
        int j=0;
        int[]rt=new int[2];
        while (i>=0&&j<=i){
            if (target<numbers[i]){
                i--;
            }else {
                if (i==j){
                    i++;
                }
                System.out.println(numbers[j]+numbers[i]);
                if (numbers[j]+numbers[i]==target){
                    rt[0]=j+1;
                    rt[1]=i+1;
                    break;
                }
                if (numbers[j]+numbers[i]<target){
                    j++;
                }
                if (numbers[j]+numbers[i]>target){
                    i--;
                }

            }
        }
        return rt;*/
    }

    public static void main(String[] args) {
        new TwoSum().twoSum2(new int[]{-3,3,4,90},0);
    }
}
