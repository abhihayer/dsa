package com.example.dsa_java.dsa.leetcode;

import java.util.Collection;

public class GenerateSubsets_Backtracking {

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> allSubsets) {
        // 🔁 Base case: we've considered all elements
        if (index == nums.length) {
            allSubsets.add(new ArrayList<>(current)); // Save a copy of the current subset
            return;
        }

        // 🔹 Choice 1: Include nums[index] in the subset
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, allSubsets);  // Move to next

        // 🔹 Backtrack: remove last added element to try next path
        current.remove(current.size() - 1);

        // 🔹 Choice 2: Exclude nums[index] from the subset
        generateSubsets(nums, index + 1, current, allSubsets);
    }
}
