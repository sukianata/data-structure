package com.hf.algroithm.leetcode.Tree;

/**
 * @author: huangfan
 * @date: 2019/3/2 21:30
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        int level=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            level++;
            int size=queue.size();
            while(size>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return level;
    }
    public int maxDepth2(TreeNode root) {
        if (root==null)
            return 0;
        return Math.max(maxDepth2(root.left),maxDepth2(root.right))+1;
    }
    public static void main(String[] args) {

       /* TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(9);
        TreeNode node3=new TreeNode(20);
        TreeNode node4=new TreeNode(15);
        TreeNode node5=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;*/
       TreeNode node1=new TreeNode(1);
       TreeNode node2=new TreeNode(2);

        MaxDepth maxDepth=new MaxDepth();
        maxDepth.maxDepth2(node1);
    }
}
