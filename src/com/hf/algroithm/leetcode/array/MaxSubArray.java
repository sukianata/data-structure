package com.hf.algroithm.leetcode.array;

/**
 * @author: huangfan
 * @date: 2019/2/28 17:53
 */
/*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    示例:

    输入: [-2,1,-3,4,-1,2,1,-5,4],
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    /**1 2 -2
     * 类似dp问题
     * dp[i]表示到以i为结束节点的子序列的最大和
     * dp[0]=nums[0];1
     * dp[1]=max{nums[1],nums[0}+nums[1]}3
     * dp[2]=max{nums[2],nums[2]+nums[1],nums[2]+nums[1]+nums[0]}
     *      =max{nums[2],nums[2]+dp[1]}
     * dp[3]=max{nums[3],nums[3]+nums[2],nums[3]+nums[2]+nums[1],nums[3]+nums[2]+nums[1]+nums[0]}
     *      =max{nums[3],nums[3]+dp[2]}
     * dp[i]=max{nums[i],nums[i]+dp[i-1]}
     * result=max{dp[0],dp[1]...dp[n]},0<=n<nums.length
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i]+dp[i-1]){
                dp[i]=nums[i];
            }else{
                dp[i]=nums[i]+dp[i-1];
            }

            if (dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
