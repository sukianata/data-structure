package com.hf.algroithm.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huangfan
 * @date: 2019/3/2 14:12
 */

/**
 * 二叉树中序遍历
 * 左-父-右
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        //迭代法
        //inorderSearch(root,list);
        //迭代法
        TreeNode cursor=root;
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||cursor!=null){
            while (cursor!=null){
                stack.push(cursor);
                cursor=cursor.left;
            }
            cursor=stack.pop();
            list.add(cursor.val);
            cursor=cursor.right;
        }
        return list;
    }
    private void inorderSearch(TreeNode node,List<Integer> list){
        if (node==null){
            return;
        }else{
            inorderSearch(node.left,list);
            list.add(node.val);
            inorderSearch(node.right,list);
        }
    }
}
