package com.example.dsa_java.dsa.leetcode;

class MoveZero_283_V1 {
    public void moveZeroes(int[] nums) {
        int left =0;
        int right =0;

        while(right<nums.length){
            if(nums[right]==0){
                right++;
                continue;
            }
            if(nums[right]!=0){
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
                right++;
            }
        }
    }
}