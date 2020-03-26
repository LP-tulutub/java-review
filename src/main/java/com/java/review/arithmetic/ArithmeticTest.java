package com.java.review.arithmetic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArithmeticTest {
}

/**
 * 1.数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字？
 *  要求：
 *      时间复杂度 O(N)
 *      空间复杂度 O(1)
 */
class duplicateO{
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

/**
 * 2.判断Java数组是否包含某个值？
 */
class findAny{
    private boolean findStr(String[] args,String str){
        boolean result = false;
        //第一种：List
        result = Arrays.asList(args).contains(str);
        //第二种：set
        Set<String> sets = new HashSet<String>(Arrays.asList(args));
        result = sets.contains(str);
        //第三种：loop
        for (String s : args) {
            if (s.equals(str)){
                return true;
            }
        }
        //第四种：binarySearch(Arrays的binarySearch方法必须应用于有序数组)
        int res = Arrays.binarySearch(args, str);
        if (res > 0){
            return true;
        }
        return result;
    }
}


















































