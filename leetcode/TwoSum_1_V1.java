package com.example.dsa_java.dsa.leetcode;

public class TwoSum_1_V1 {

    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];

        for(int i = 0; i<nums.length-1; i++) {
            int find = target - nums[i];
            boolean flag = false;
            for(int j = i+1; j<nums.length; j++) {
                if(nums[j]==find){
                    flag = true;
                    ans[1] = j;
                    break;
                }
            }

            if(flag) {
                ans[0] = i;
                break;
            }
        }

        return ans;

    }
}