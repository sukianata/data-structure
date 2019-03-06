package com.hf.algroithm.leetcode;

import java.util.*;

/**
 * @author: huangfan
 * @date: 2019/3/4 09:46
 */
public class Solution {

    public boolean isHappy(int n){
        Set<Integer>set=new HashSet<>();
        while (n!=1){
            int t=0;
            while (n!=0){
                t+=(n%10)*(n%10);
                n=n/10;
            }
            n=t;
            if (set.contains(n))
                return false;
            else
                set.add(n);
        }
        return true;
    }
    public int getSum(int a, int b) {
        while (b!=0){
            int _a=a^b;
            int _b=(a&b)<<1;
            a=_a;
            b=_b;
        }
        return a;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        int i=0;
        int j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                list.add(nums1[i++]);
            }else if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else{
                list.add(nums2[j++]);
            }
        }
        while(i<nums1.length){
            list.add(nums1[i++]);
        }
        while(j<nums2.length){
            list.add(nums2[j++]);
        }
        int size=list.size();
        if(size%2==0)
            return (double)(list.get(size/2-1)+list.get(size/2))/2;
        else
            return (double)list.get(size/2);
    }
    public boolean isPalindrome(int x) {
        String s=x+"";
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)=='-'){
                i++;
                continue;
            }else{
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while(i<j){
            if(height[i]<height[j]){
                max=Math.max(max,height[i]*(j-i+1));
                i++;
            }else{
                max=Math.max(max,height[j]*(j-i+1));
                j--;
            }
        }
        return max;
    }
    static String[] char_count(String[] str_arr) {
        //两个指针
        if(str_arr==null) return null;
        int i=0;
        int j=0;
        int len=str_arr.length;
        List<String> rt=new ArrayList<>();
        while(i<len&&j<len){
            int num=0;
            while(j<len&&str_arr[j]==str_arr[i]){//找到第一个不同的的字母
                num++;//有一个相同便加一，然后挪动指针
                j++;
            }
            rt.add(str_arr[i]);//保存字母
            rt.add(num+""); //保存字母个数
            i=j;
        }
        String[] s=new String[rt.size()];
        for(int k=0;k<rt.size();k++){
            s[k]=rt.get(k);
        }
        return s;
    }

    public static void main(String[] args) {
        String[] str=new String[]{"a","a","b","v"};
        String[] res = char_count(str);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }

}
