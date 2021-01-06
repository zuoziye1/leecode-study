package com.leecodestudy.leecode.数组相关.排序;

import java.util.Arrays;


/**
 * 冒泡排序
 *
 * https://www.cnblogs.com/LearnAndGet/p/10237399.html
 *
 * 稳定性： 参考：https://www.cnblogs.com/tigerson/p/7156648.html
 * 如一个数组是 4 5 2 4 6
 * 如果排序后，两个4 （即相同的元素）的相对前后位置不变， 即若第一个4仍然在第二个4前面，则说明它是稳定的算法
 *
 * 那么他有什么用呢，假设这里的数组元素是不同的商品的销量，以万为单位，但是呢，这里的两个4，第一个的价格是 30元，第二个4的价格是40元，
 * 我们希望排序后，他们的相对顺序不要变，即，销量相同的按价格顺序排列，这样，原来的相同的相对位置就重要了。
 *
 * 冒泡排序是稳定的。
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        sort3(arr);
        Arrays.stream(arr).forEach(
                System.out::println
        );
    }

    public static void sort(int[] arr){
        int tmp ;

        /**
         * 因为冒泡是有N个值，会有N-1 次冒泡，所以是 i< arr.length -1
         */
        for (int i = 0; i < arr.length -1; i++) {
            /**
             * 5 4 3 8 1
             *
             * 因为第一次冒泡是5和4互换，把小的值放在了前面 4 5 3 8 1
             * 第二次：5和3 换， 变成了 4 3 5 8 1
             * 第三次：5 和 8 不用动
             * 第四次：8 和 1 互换  变成了 4 3 5 1 8
             *
             * 因此，一次冒泡结束后，最大的值被挪到了最后，因此， j=0要从头开始，而 j < arr.length -1 是可以优化的
             * 显然可以优化成 j < arr.length -1 - i ,因为 i = 0 开始，i 加1，则arr.length -1 就可以减1，他们是相反对应的。
             */
            for (int j = 0 ; j < arr.length -1 ; j++) {
                if(arr[j+1] < arr[j]){
                    tmp = arr[j+1] ;
                    arr[j+1] = arr[j] ;
                    arr[j] = tmp ;
                }
            }
        }
    }

    /**
     * 优化
     */
    public static void sort2(int[] array){
        int length = array.length;
        for (int i = 0; i < length-1; i++) {
            // 因为经过了前面的相邻位置比较互换后，最后的一个元素肯定是最大的，同理，经过n轮后，最后的n个元素肯定是依次最大的
            // 因此第二轮可以比第一轮少最后一个元素进行前面的过程，同样，第三轮可以比第二轮少最后两个元素进行相邻元素比对的过程
            for (int j = 0; j < length-1-i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp ;
                }
            }
            System.out.println("第"+(i+1)+"轮排序后的数组为: "+ Arrays.toString(array));
        }
    }

    /**
     * 再优化
     *
     * 没优化前：
     * 第1轮排序后的数组为: [1, 0, 2, 3, 4, 5]
     * 第2轮排序后的数组为: [0, 1, 2, 3, 4, 5]
     * 第3轮排序后的数组为: [0, 1, 2, 3, 4, 5]
     * 第4轮排序后的数组为: [0, 1, 2, 3, 4, 5]
     * 第5轮排序后的数组为: [0, 1, 2, 3, 4, 5]
     *
     * 我们发现其实第二轮比较完后就可以结束了。
     */
    public static void sort3(int[] array){
        int length = array.length;
        for (int i = 0; i < length-1; i++) {

            /**
             * 标记某一轮的冒泡过程是否实际有元素互换的情况。
             *
             * 如果本轮没有相邻元素的互换，则说明已经排序完成了，后面若再执行，其实还是这样重复的过程，没有相邻元素的互换
             */
            boolean flag = false ;
            for (int j = 0; j < length-1-i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp ;
                    flag = true ;
                }
            }
            System.out.println("第"+(i+1)+"轮排序后的数组为: "+ Arrays.toString(array));
            if(!flag){
                System.out.println("第"+(i+1)+"轮排序后发现已经没有需要元素互换的地方了，即排序结束。");
                return;
            }
        }
    }

}
