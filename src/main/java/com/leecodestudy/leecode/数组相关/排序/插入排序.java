package com.leecodestudy.leecode.数组相关.排序;

import java.util.Arrays;

/**
 *
 * 思路：就是将后面无序的元素插入到前面有序的数组中去
 *
 * 时间复杂度：
 * 如果序列本来是排好序的，那么会触发最好情况。这时只需要n-1次比较即可，没有任何元素移动。所以最好情况下时间复杂度是 O(n)。
 * 如果序列是逆序排列的，那么会触发最坏情况。这时每个元素都需要一步一步地挪到序列首部。所以最坏情况下的时间复杂度是 O(n^2)。
 *
 * @Author: 姚飞虎
 * @Date: 2021/1/5 1:18 下午
 * @Description:
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        sort(arr);
        Arrays.stream(arr).forEach(
                System.out::println
        );
    }

    public static void sort(int[] arr){
        int length = arr.length ;
        int tmp ;
        for (int i = 1; i < length; i++) {
            // 这里用的是冒泡的方式，将下一个元素插入到前面排好序的数组中
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    tmp = arr[j] ;
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp ;
                }
            }
        }
    }
}
