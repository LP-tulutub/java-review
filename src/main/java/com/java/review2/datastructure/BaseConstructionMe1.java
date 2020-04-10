package com.java.review2.datastructure;

import com.java.review2.rely.PrintArray;


public class BaseConstructionMe1 {
    public static void main(String[] args) {
        BaseConstructionMe1 bc = new BaseConstructionMe1();
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
        int temp = 0;
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){
                //如果后比前小，则交换
                if (arr[j+1] < arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public void bubbleSort2(int[] arr){
        int temp = 0;
        for (int i=0; i<arr.length-1; i++){
            //在某种情况下可以证明数组已经完成排序，这时候可以直接退出循环了
            int flag = 0;
            for (int j=0; j<arr.length-i-1; j++){
                //如果后比前小，则交换
                if (arr[j+1] < arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag==1){
                break;
            }
        }
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
        int temp = 0;
        for (int i=0; i<arr.length-1; i++){
            //找出最小的数的位置
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //把最小的放到当前位置
            if (i != minIndex){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    public void selectSort2(int[] arr){
        //答题
        for (int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                if (arr[i] > arr[j]){
                    int gd = arr[i];
                    arr[i] = arr[j];
                    arr[j] = gd;
                }
            }
        }
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
        int i, j;
        for (i=1; i<arr.length; i++){
            //用当前的数找到应该在前面的位置
            int temp = arr[i];
            //整体向后移，留出空位
            for (j=i; j>0 && temp<arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    /**
     * Input:
     *      arr4 = {5, 3, 6, 1, 10, 8}
     * Output: [1,3,5,6,8,10]
     * Explanation:
     *      从右向左找第一个小于key的值，从左向右找第一个大于key的值
     * condition: 快速排序，O(NLogN)
     */
    public void quickSort(int a[],int l,int r){
        if(l>=r)
            return;
        int i = l; int j = r; int key = a[l];//选择第一个数为key
        while(i<j){
            while(i<j && a[j]>=key)//从右向左找第一个小于key的值
                j--;
            if(i<j){
                a[i] = a[j];
                i++;
            }
            while(i<j && a[i]<key)//从左向右找第一个大于key的值
                i++;
            if(i<j){
                a[j] = a[i];
                j--;
            }
        }
        //i == j
        a[i] = key;
        quickSort(a, l, i-1);//递归调用
        quickSort(a, i+1, r);//递归调用
    }







}





