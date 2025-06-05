package com.example.dsa_java.dsa.leetcode;

public class RunningSum_1480 {

    public int[] output(int[] nums){
        int[] runningSum = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            runningSum[i] = i==0?nums[i]:runningSum[i-1]+nums[i];
        }

        return runningSum;
    }

}
