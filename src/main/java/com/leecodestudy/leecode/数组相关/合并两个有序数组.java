package com.leecodestudy.leecode.数组相关;

import java.util.Arrays;

public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,7,9};
        int[] b = new int[]{2,4,6,8,10};
        int[] array = getArray(a, b);
        Arrays.stream(array).forEach(
                System.out::println
        );
    }

    public static int[] getArray(int[] arr1,int[] arr2){
        int length1 = arr1.length ;
        int length2 = arr2.length ;
        int[] array = new int[length1+length2] ;
        int arrayIndex = 0 ;
        int p1 = 0 ;
        int p1End = length1 -1 ;
        int p2 = 0 ;
        int p2End = length2 - 1 ;

        while (p1 <= p1End || p2 <= p2End) {
            if(p1 <= p1End && p2 <= p2End){
                array[arrayIndex++] = arr1[p1] < arr2[p2] ? arr1[p1++] : arr2[p2++] ;
            }
            else if(p1 <= p1End){
                array[arrayIndex++] = arr1[p1++];
            }
            else if(p2 <= p2End){
                array[arrayIndex++] = arr2[p2++];
            }
        }
        return array ;
    }
}
