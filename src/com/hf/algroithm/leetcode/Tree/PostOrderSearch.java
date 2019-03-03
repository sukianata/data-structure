package com.hf.algroithm.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: huangfan
 * @date: 2019/3/3 13:08
 * 后序遍历
 */
public class PostOrderSearch {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        //方法一：递归
//        postOrder(root,list);
        //方法二迭代法
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        TreeNode head=root;
        while (!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode node=queue.poll();
                if(node!=head){
                    if (node.left!=null)
                        queue.offer(node.left);
                    else

                    if (node.right!=null)
                        queue.offer(node.right);
                    queue.offer(node);
                }
                size--;

            }

        }
        return list;


    }
    private void postOrder(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        else
            postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(2);
        TreeNode c=node;
        System.out.println(c==node);
    }
}
