package com.example.dsa_java.dsa.leetcode;

public class SASXT_1863_V1 {
    Set<Set<InxNum>> set= new HashSet<>();

    class InxNum {
        int inx;
        int val;
    }

    public int subsetXORSum(int[] nums) {
        InxNum[] inums = new InxNum[nums.length];
        for(int i=0; i<nums.length; i++){
            inums[i] = new InxNum();
            inums[i].inx = i;
            inums[i].val = nums[i]; 
        }

        set.add(returnSet(inums));
        return allSubsets(inums); 
    }

    public Set<InxNum> returnSet(InxNum[] arr){
        Set<InxNum> sset = new HashSet<>();
        for(InxNum in: arr) {
            sset.add(in);
        }    
        return sset;
    }

    public int allSubsets (InxNum[] nums){
        if(nums.length == 0) return 0;

        
        int sum = 0;
        // create subsets of n-1
        for(int i=0; i<nums.length; i++) {
            int k = 0;
            InxNum[] subset = new InxNum[nums.length-1];
            for(int j =0; j<nums.length; j++){
                if(i!=j) {
                    subset[k++] = nums[j];
                }
            }

            // each subset calculated xor sum added if it not already calculated;
            Set<InxNum> sset = returnSet(subset);
            if(!set.contains(sset)){
                set.add(sset);
                sum = sum+allSubsets(subset);
            }
        }

        // calculating current subset xor sum
        int currSubsetSum = 0;
        for(int i=0; i<nums.length; i++){
            currSubsetSum = currSubsetSum^nums[i].val;
        }

        return currSubsetSum+sum;

    }
}

