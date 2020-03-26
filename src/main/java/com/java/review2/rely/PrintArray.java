package com.java.review2.rely;

import java.util.Arrays;

public class PrintArray {
    public static void printInt(int[] nums, String name){
        if (nums == null){
            System.out.println(name + ": null");
        }else {
            System.out.print(name + ": [");
            for (int i=0; i<nums.length; i++){
                if (i != nums.length-1) System.out.print(nums[i] + ",");
                else System.out.print(nums[i]);
            }
            System.out.println("]");
        }
    }

    public static void printObj(Object[] nums, String name){
        if (nums == null){
            System.out.println(name + ": null");
        }else {
            System.out.print(name + ": [");
            for (int i=0; i<nums.length; i++){
                if (i != nums.length-1) System.out.print(nums[i] + ",");
                else System.out.print(nums[i]);
            }
            System.out.println("]");
        }
    }

    public static void print2Int(int[][] nums, String name){
        if (nums == null){
            System.out.println(name + ": null");
        }else {
            System.out.print(name + ": [");
            for (int i=0; i<nums.length; i++){
                if (i != nums.length - 1) System.out.print(Arrays.toString(nums[i]) + ", ");
                else System.out.print(Arrays.toString(nums[i]));
            }
            System.out.println("]");
        }
    }


}
