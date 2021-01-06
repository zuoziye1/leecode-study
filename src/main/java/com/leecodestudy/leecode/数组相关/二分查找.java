package com.leecodestudy.leecode.数组相关;

/**
 * 二分查找
 */
public class 二分查找 {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};
        int index = getIndex(array, 1);
        System.out.println(index);
    }

    public static int getIndex(int[] array,int target){
        int start = 0 ;
        int end = array.length -1 ;
        while (start <= end ){
            int midIndex = (start+end)/2;
            int mid = array[midIndex] ;

            if(mid == target){
                return midIndex ;
            }

            if(mid < target){
                start = midIndex + 1 ;
            }
            if(mid > target){
                end = midIndex - 1 ;
            }
        }
        return -1 ;
    }
}
