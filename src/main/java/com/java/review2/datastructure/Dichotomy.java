package com.java.review2.datastructure;

public class Dichotomy {
    public static void main(String[] args) {
        // binarySearch
        int[] num = {1,2,3,4,5};
        System.out.println("binarySearch: " + binarySearch(num, 3));
        // mySqrt
        System.out.println("mySqrt: " + mySqrt(8));
        // nextGreatestLetter
        char[] letters = {'c', 'f', 'j', 'z'};
        char target = 'd';
        System.out.println("nextGreatestLetter: " + nextGreatestLetter(letters, target));
        // singleNonDuplicate
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("singleNonDuplicate: " + singleNonDuplicate(nums));
        // findMin
        int[] nums2 = {3,4,5,1,2};
        System.out.println("findMin: " + findMin(nums2));
        // searchRange
        int[] nums3 = {5,7,7,8,8,10};
        int[] ints3 = searchRange(nums3, 8);
        System.out.println("searchRange: " + ints3[0] + "," + ints3[ints3.length-1]);

    }

    /**
     * Input:
     *      nums = {1,2,3,4,5}
     *      key = 3
     * Output: 2
     * condition: 二分法实现查找索引
     */
    private static int binarySearch(int[] nums, int key) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h){
            int m = l + (h-l)/2;
            if (nums[m] == key){
                return m;
            }else if (nums[m] > key){
                h = m - 1;
            }else {
                l = m + 1;
            }
        }
        return -1;
    }

    /**
     * Input:
     *      x = 8
     * Output: 2.8284
     * condition: 二分法实现求开方，保留4位小数
     */
    private static double mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        double end = 0;
        double digit = 0.0001;
        double l = 0, h = x;
        while (l <= h) {
            double mid = l + (h-l)/2;
            String format = String.format("%.4f", mid);
            mid = Double.parseDouble(format);
            if ((mid*mid)<=x && ((mid+digit)*(mid+digit))>x) {
                end = mid;
                break;
            } else if ((mid*mid) > x) {
                h = mid - digit;
            } else {
                l = mid + digit;
            }
        }
        return end;
    }

    /**
     * Input:
     *      letters = {'c', 'f', 'j', 'z'}
     *      target = 'd'
     * Output: f
     * condition: 找出大于target的最小字符
     */
    private static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l <= h){
            int m = l + (h-l)/2;
            if (letters[m] > target){
                h = m - 1;
            }else {
                l = m + 1;
            }
        }
        return l<letters.length ? letters[l] : letters[0];
    }

    /**
     * Input:
     *      nums = {1, 1, 2, 3, 3, 4, 4, 8, 8}
     * Output: 2
     * condition: 一个有序数组只有一个数不出现两次，找出这个数，O(logN)时间复杂度
     */
    private static int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h){
            int m = l + (h-l)/2;
            if (m%2 == 1){
                m--;
            }
            if (nums[m] != nums[m+1]){
                h = m - 1;
            }else {
                l = m + 1;
            }
        }
        return nums[l+1];
    }

    /**
     * Input:
     *      nums = {3,4,5,1,2}
     * Output: 1
     * condition: 旋转数组，找出最小的数，O(logN)时间复杂度
     */
    private static int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h-l)/2;
            if (nums[m] <= nums[h]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    /**
     * Input:
     *      nums = {5,7,7,8,8,10}
     *      target = 8
     * Output: [3,4]
     * Input:
     *      nums = {5,7,7,8,8,10}
     *      target = 6
     * Output: [-1,-1]
     * condition: 查找区间，O(logN)时间复杂度
     */
    private static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }
    private static int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l < h){
            int m = l + (h-l)/2;
            if (nums[m] >= target){
                h = m - 1;
            }else {
                l = m + 1;
            }
        }
        return l;
    }


}
