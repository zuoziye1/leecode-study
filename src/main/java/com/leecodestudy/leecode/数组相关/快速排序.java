package com.leecodestudy.leecode.数组相关;

import java.util.Arrays;

/**
 * @Author: 姚飞虎
 * @Date: 2021/1/4 2:13 下午
 * @Description:
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        左右划分(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(
                System.out::println
        );
    }

    public static void 左右划分(int[] array, int start, int end) {

        if (start > end) {
            return;
        }

        int startOrigin = start;
        int endOrigin = end;
        int standard = array[start];

        while (start < end) {

            /**
             * 右侧先动，能让他停下的位置，一定是小于等于基准值，或者是与左侧的index碰头了
             */
            while (array[end] >= standard && start < end) {
                end--;
            }

            while (array[start] <= standard && start < end) {
                start++;
            }

            if (start < end) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }

        array[startOrigin] = array[start];
        array[start] = standard;

        左右划分(array, startOrigin, end - 1);
        左右划分(array, end + 1, endOrigin);

    }
}
