package com.hf.algroithm.leetcode.Sort;

/**
 * @author: huangfan
 * @date: 2019/3/2 12:37
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 给出一个区间的集合，请合并所有重叠的区间。

 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2:

 输入: [[1,4],[4,5]]
 输出: [[1,5]]
 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeSpace {
    private class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        /**
         * 定义一个指针i从头开始遍历所有区间
         * 从第一个i开始，若后面的区间j的起点小于i的终点，j的终点大于i的终点，则更新i的重点为j的重点，j++
         * 若j的起点大于i的重点，则list.add(i),i=j,j++
         */
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;//根据起点升序排列
            }
        });
        LinkedList<Interval> list=new LinkedList<>();
        for (Interval bean:intervals){
            if (list.isEmpty()||list.getLast().end<bean.start){
                list.add(bean);
            }else{
                list.getLast().end=Math.max(bean.end,list.getLast().end);
            }
        }
        return list;
    }
}
