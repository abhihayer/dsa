package com.example.dsa_java.dsa.leetcode;

import java.util.Collection;

public class LDS_368_V1 {
    List<List<Integer>> allsubsets = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numsl = Arrays.stream(nums).boxed().collect(Collectors.toList());
        
        largestSubset(0, numsl, new ArrayList<>());

        int max = 0;
        List<Integer> sub = null;
        for(List<Integer> li: allsubsets){
            Collections.sort(li);
            boolean flag = true;
            for(int i = li.size()-1; i>0; i--){
                if(li.get(i)%li.get(i-1)!=0){
                    flag = false;
                }
            }
            if(flag){
                if(li.size() > max){
                    max = li.size();
                    sub = li;
                }
            }
        }

        return sub;
    }

    public void largestSubset(int index, List<Integer> nums, List<Integer> subset)
     {
        if(index == nums.size()) {
            
            allsubsets.add(new ArrayList<>(subset));
            return ;
        } else if (subset.size > 1)(
            List<Integer> temp = new ArrayList<>(subset);
            if(temp.get(0)%temp.get(1)!==0 || temp.get(1)%temp.get(0)!==0) return ;
        )

        subset.add(nums.get(index));
        largestSubset(index+1, nums, subset);
        
        subset.remove(subset.size()-1);

        largestSubset(index+1, nums, subset);
    }


}