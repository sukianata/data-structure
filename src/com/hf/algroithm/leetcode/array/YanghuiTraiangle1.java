package com.hf.algroithm.leetcode.array;

/**
 * @author: huangfan
 * @date: 2019/2/28 21:38
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 5
 输出:
 [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
 ]
 */
public class YanghuiTraiangle1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outList=new ArrayList<>();
        /**
         * 建立二维数组 用动态规划
         */
        int[][] arr=new int[numRows][numRows];
        for (int j=0;j<numRows;j++){
            arr[0][j]=1;
        }
        for (int j=1;j<numRows;j++){
            for (int i=1;i<=j;i++){
                if (i==j){
                    arr[i][j]=1;
                }else {
                    arr[i][j]=arr[i-1][j-1]+arr[i][j-1];
                }
            }
        }
        for (int j=0;j<3;j++){
            List<Integer> inList=new ArrayList<>();
            for (int i=0;i<=j;i++){
                inList.add(arr[i][j]);
            }
            outList.add(inList);
        }

        return outList;
    }

    public static void main(String[] args) {
        new YanghuiTraiangle1().generate(3);
    }
}

