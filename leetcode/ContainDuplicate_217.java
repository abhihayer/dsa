package com.example.dsa_java.dsa.leetcode;

import java.util.Map.Entry;

public class ContainDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int i:nums) {
            if(numSet.contains(i)) {
                return true;
            }
            else {
                numSet.add(i);
            }
        }

        return false;
    }
}
