package com.example.dsa_java.dsa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber_136 {

    public int singleNumber_MAP(int[] nums) {
        Map<Integer,Integer> numberMap = new HashMap<>();
        
        for(int i:nums) {
            numberMap.put(i, numberMap.getOrDefault(i, 0)+1);
        }

        for(int k: numberMap.keySet()){
            if(numberMap.get(k) == 1) {
                return k;
            }
        }
        return -30001;
    }

    public int singleNumber_SET(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        
        for(int i:nums){
            if(numberSet.contains(i)) {
                numberSet.remove(i);
            }
            else{
                numberSet.add(i);
            }
        }

        for(int i: numberSet) {
            return i;            
        }

        return -30001;        
    }

    public int singleNumber_XOR(int[] nums) {
        int result = 0;

        for(int i: nums){
            result = result^i;
        }

        return result;
    }
}
