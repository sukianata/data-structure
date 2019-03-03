package com.hf.algroithm.leetcode.Tree;

/**
 * @author: huangfan
 * @date: 2019/3/3 12:25
 */

import java.util.Arrays;

/**
 *
 给定一个非空二叉树，返回其最大路径和。

 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

 示例 1:

 输入: [1,2,3]

  1
 / \
 2   3

 输出: 6
 示例 2:

 输入: [-10,9,20,null,null,15,7]

 -10
 / \
 9   20
    /  \
   15   7
 */
public class MaxPathSum {

    private int ret=Integer.MIN_VALUE;//最大路径和
    public int maxPathSum(TreeNode root) {
        /**
         * 目标是求出最大值
         * 对于任意一节点，若最大路径和包含该节点
         *  则要么是该节点左右节点中最大和 加上该节点的值
         *  要么是左节点+该节点+右节点
         * 左子树的最大值为leftMax,右为rightMax
         *
         */
        getMax(root);
        return ret;
    }

    /**
     * 求向左走的最大值和向右走最大值的方法
     * @param root
     * @return
     */
    private int getMax(TreeNode root){
        if(root==null)
            return 0;
        int left=Math.max(0,getMax(root.left));//若root.left 最大值为负数，则肯定不加的好，越加越小，
        int right=Math.max(0,getMax(root.right));
        ret=Math.max(ret,root.val+left+right);
        return Math.max(left,right)+root.val;//当左右子节点值为0时，此处返回的是当前节点的值
    }
    private int designMax(int...nums){
        Arrays.sort(nums);
        return nums[nums.length-1];
    }
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(-3);
        TreeNode node2=new TreeNode(-2);
        TreeNode node3=new TreeNode(-1);
        node1.left=node2;
        node1.right=node3;
        MaxPathSum sum=new MaxPathSum();
        sum.maxPathSum(node1);
    }
}
