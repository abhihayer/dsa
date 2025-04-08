package com.example.dsa_java.dsa.leetcode;

public class MNOMD_3396 {

    public int minimumOperations(int[] nums) {
        int i = returnIndex(nums);
        System.out.println(i);
        return i/3 + (i%3!=0?1:0);
    }

    int returnIndex(int[] nums){
        Set<Integer> distinct = new HashSet<>();

        int end = nums.length-1;
        
        for(int i=nums.length-1; i>=0; i--) {
            if(distinct.contains(nums[i])) {
                break;
            }
            else {
                distinct.add(nums[i]);
                end = i;
            }
        }

        return end;
    } 
    

}
