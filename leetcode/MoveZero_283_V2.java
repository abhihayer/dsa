package com.example.dsa_java.dsa.leetcode;

class MoveZero_283_V2 {
    public void moveZeroes(int[] nums) {
        int zIndex = -1;

        int i = 0;
        while(i<nums.length){
            if(nums[i]==0) {
                if(zIndex==-1) zIndex = i;
            }
            else{
                if(zIndex < i && zIndex!=-1) {
                    nums[zIndex] = nums[i];
                    nums[i] = 0;
                    i=zIndex;
                    zIndex = -1;
                }
            }
            i++;
        }
    }
}
