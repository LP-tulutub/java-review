package com.java.review2.practice;

import com.java.review2.rely.PrintArray;

/**
 * 复习情况：4/3 ① 4/6 ④ 4/10 ⑦
 */
public class BaseConstructionMePractice1 {
    public static void main(String[] args) {
        BaseConstructionMePractice1 bc = new BaseConstructionMePractice1();
        // bubbleSort
        int[] arr1 = {5, 3, 6, 1, 10, 8};
        bc.bubbleSort(arr1);
        PrintArray.printInt(arr1, "bubbleSort");
        // selectSort
        int[] arr2 = {5, 3, 6, 1, 10, 8};
        bc.selectSort(arr2);
        PrintArray.printInt(arr2, "selectSort");
        // insertSort
        int[] arr3 = {5, 3, 6, 1, 10, 8};
        bc.insertSort(arr3);
        PrintArray.printInt(arr3, "insertSort");
        // quickSort
        int[] arr4 = {5, 3, 6, 1, 10, 8};
        bc.quickSort(arr4, 0, 5);
        PrintArray.printInt(arr4, "quickSort");

    }

    /**
     * Input:
     *      arr1 = {5, 3, 6, 1, 10, 8}
     * Output: [1,3,5,6,8,10]
     * Explanation:
     *      如果后比前小，则交换
     * condition: 冒泡排序法代码，O(n2)
     */
    public void bubbleSort(int[] arr){
        //答题

    }

    /**
     * Input:
     *      arr2 = {5, 3, 6, 1, 10, 8}
     * Output: [1,3,5,6,8,10]
     * Explanation:
     *      找出最小的数的位置，把最小的放到当前位置
     * condition: 选择排序，O(n2)
     */
    public void selectSort(int[] arr){
        //答题

    }

    /**
     * Input:
     *      arr3 = {5, 3, 6, 1, 10, 8}
     * Output: [1,3,5,6,8,10]
     * Explanation:
     *      整体向后移，留出空位
     * condition: 插入排序法，O(n2)
     */
    public void insertSort(int[] arr){
        //答题

    }

    /**break
     * Input:
     *      arr4 = {5, 3, 6, 1, 10, 8}
     * Output: [1,3,5,6,8,10]
     * Explanation:
     *      从右向左找第一个小于key的值，从左向右找第一个大于key的值
     * condition: 快速排序，O(NLogN)
     */
    public void quickSort(int a[], int l, int r){
        //答题

    }


}
