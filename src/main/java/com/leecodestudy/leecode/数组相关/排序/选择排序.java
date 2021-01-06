package com.leecodestudy.leecode.数组相关.排序;

import java.util.Arrays;

/**
 * @Author: 姚飞虎
 * @Date: 2021/1/5 9:51 上午
 * @Description:
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        sort(arr);
        Arrays.stream(arr).forEach(
                System.out::println
        );
    }

    public static void sort(int[] array){
        int end = array.length;
        int tmp ;
        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if(array[i] > array[j]){
                    tmp = array[i] ;
                    array[i] = array[j] ;
                    array[j] = tmp ;
                }
            }
        }
    }
}
