package com.hf.algroithm.leetcode.Tree;

import java.util.*;

/**
 * @author: huangfan
 * @date: 2019/3/2 22:33
 */

/**
 *
 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其自底向上的层次遍历为：

 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //此处可以用LinekedList 不用stack 然后进行链表的反转 set方法
        List<List<Integer>> rt=new LinkedList<>();

        if(root==null) {
            return null;
        }
        //先用队列 然后用栈
        Stack<List<Integer>> stack=new Stack<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            while(size>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                list.add(node.val);
                size--;
            }
            stack.push(list);
        }
        while(!stack.isEmpty()){
            rt.add(stack.pop());
        }
        return rt;
    }
}
