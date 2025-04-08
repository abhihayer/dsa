package com.example.dsa_java.dsa.leetcode;

class MaximumTriplet_2874_V2 {
    public long maximumTripletValue(int[] nums) {
        long rmax = 0; 
        int imax = 0;
        int dmax = 0;

        for(int j=0; j<nums.length; j++) {
            rmax = Math.max(rmax,(long)dmax*nums[j]);
            dmax = Math.max(dmax,imax - nums[j]);
            imax = Math.max(imax,nums[j]);
        }

        return rmax;
    }
}