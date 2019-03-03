package com.hf.algroithm.leetcode.Tree;

import java.util.*;

/**
 * @author: huangfan
 * @date: 2019/3/2 18:56
 */

/**
 *
 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //层序遍历 队列？先进先出
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> list=new ArrayList<>();

        while (!queue.isEmpty()){
            List<Integer> ll=new ArrayList<>();
            int count=queue.size();
            while(count>0){
                TreeNode node=queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                ll.add(node.val);
                count--;
            }
            list.add(ll);
        }
        Stack stack=new Stack();
        return list;
    }


}
