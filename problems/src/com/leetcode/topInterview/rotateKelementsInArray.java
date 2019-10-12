package com.leetcode.topInterview;

import java.util.Arrays;

// Given an array, rotate the array to the right by k steps, where k is non-negative.
public class rotateKelementsInArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private static void reverse(int [] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
