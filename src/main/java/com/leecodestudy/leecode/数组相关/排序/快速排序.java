package com.leecodestudy.leecode.数组相关.排序;

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
             *
             * https://www.processon.com/diagraming/5e0490ece4b0aef94cb0b11f
             *
             * 右侧先动，能让他停下的位置，一定是小于等于基准值，或者是与左侧的index碰头了，最差的情况二者在 index = 0 处 碰头
             *
             * 如果左侧先动了，就可能会出现在index = length -1 处碰头了，而基准值又是 index = 0
             * 碰头后又需要交换二者，这就出现了基准值左边出现了大于基准值的数据，就错了。
             *
             * 为什么临界点要有等号，因为我们要把数组按照基准值分成两半，左边都是小于等于它的，右边都是大于等于它的，
             * 为什么需要 start < end ，因为当end--后，start未动，但是可能也会出现end = start
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
