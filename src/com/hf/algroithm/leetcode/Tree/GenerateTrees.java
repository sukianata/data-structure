package com.hf.algroithm.leetcode.Tree;

/**
 * @author: huangfan
 * @date: 2019/3/2 15:12
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

 示例:

 输入: 3
 输出:
 [
 [1,null,3,2],
 [3,2,null,1],
 [3,1,null,null,2],
 [2,1,3],
 [1,null,2,null,3]
 ]
 解释:
 以上的输出对应以下 5 种不同结构的二叉搜索树：

 1         3     3      2      1
  \       /     /      / \      \
  3     2     1      1   3      2
 /     /       \                 \
2     1         2                 3
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        //假如以i作为根节点，那么就是先生成左子树，有m种可能，再生成右子树有k种可能
        //那么所有的可能性可以随意组合 ，有m*n种可能，要把所有的数都用上
        //则以i为根节点时,左子树要用到的数为1~i-1,右子树用到i~n
        //如何建立左子树树呢 递归
        //从简单的开始 假如只有一个数，如何建立一棵树，那就是左右子节点为空
        //假如有1，2两个数呢
        //首先假设以1为根节点，那么首先建立左子树，能用到的数为1~0,不成立，则1的左子树为null
        //然后建立右子树，能用到的数为2~2,问题回归到如何用2这个数建立一个棵树
        //其次假设以2为根节点，那么左子树能用到的数为1~1，回归到如何用1建立一棵树
        //右子树能用到的数为3~2,不成立
        //所以用1，2两个数建树的可能性就是以上两种情况加起来
        List<TreeNode> list=new ArrayList<>();
        if (n==0){
            return list;
        }
        return generateTree(1,n);
    }

    /**
     *
     * @param begin 能用到的数的最小值
     * @param end 能用到的数的最大值
     * @return
     */
    private List<TreeNode> generateTree(int begin,int end){
        List<TreeNode> list=new ArrayList<>();
        if (begin>end){
            list.add(null);
            return list;
        }
        for (int i=begin;i<=end;i++){
            List<TreeNode> leftList=generateTree(begin,i-1);
            List<TreeNode> rightList=generateTree(i+1,end);
            //所有左子树，右子树的可能性都列出了，接下来进行组合
            for(TreeNode left:leftList){
                for (TreeNode right:rightList){
                    TreeNode node=new TreeNode(i);//以i作为根节点
                    node.left=left;
                    node.right=right;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new GenerateTrees().generateTrees(3);
    }
}
