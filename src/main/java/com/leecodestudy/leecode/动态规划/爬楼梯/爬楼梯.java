package com.leecodestudy.leecode.动态规划.爬楼梯;

/**
 *
 * 题目及解答：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
 * @Author: 姚飞虎
 * @Date: 2021/5/11 4:22 下午
 * @Description:
 * n 阶楼梯，每次爬一阶或者两阶，一共有多少种方式可以爬完
 */
public class 爬楼梯 {

    public static void main(String[] args) {
        System.out.println(fn(3));
    }

    /**
     * 斐波那契数列
     * 时间复杂度是 o(N^2)
     * @param n
     * @return
     */
    public static int fn(int n){
        if(n == 0 || n == 1){
            return 1 ;
        }else {
            return fn(n-1) + fn(n-2) ;
        }
    }

    /**
     * 滑动数组
     * @param n
     * @return
     */
    public static int 动态规划(int n){
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


}
