package com.example.dsa_java.dsa.leetcode;

class MaximumTriplet_2874_V1 {
    public long maximumTripletValue(int[] nums) {
        long rmax = 0; 

        for(int j=1; j<nums.length-1; j++) {
            int imax = 0;
            for(int i=0; i<j; i++){
                imax = Math.max(imax,nums[i]);
            }

            int kmax = 0;
            for(int k=j+1; k < nums.length; k++) {
                kmax = Math.max(kmax,nums[k]);
            }
            rmax = Math.max(rmax,(long)(imax - nums[j])*kmax);
        }
        return rmax;
        
    }
}