package com.example.dsa_java.dsa.leetcode;

public class MergeArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];

        int j = 0; int k = 0;
        for(int i=0; i<temp.length; i++) {
            if(m > 0 && n > 0) {
                if(k==n || j!=m && nums1[j] <= nums2[k]) {
                    temp[i] = nums1[j];
                    j++;
                }
                else {
                    temp[i] = nums2[k];
                    k++;
                }
            }
            if(n==0) {
                temp[i] = nums1[i];
                j++;
            }
            if(m==0) {
                temp[i] = nums2[i];
                k++;
            }
        }
        for(int i=0; i<nums1.length; i++) {
            nums1[i] = temp[i];
        }

    }
}