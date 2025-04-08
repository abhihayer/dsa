package com.example.dsa_java.dsa.leetcode;

public class TwoSum_1_V2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> sumToIndices = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
             int find = target-nums[i];
             if(sumToIndices.get(find) !=null) {
                return new int[]{i, sumToIndices.get(find)};
             } else {
                sumToIndices.put(nums[i], i);
             }
        }
        return null;
    }



}