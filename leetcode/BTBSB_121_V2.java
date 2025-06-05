package com.example.dsa_java.dsa.leetcode;

class BTBSB_121_V2 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
           int cost = prices[i] - min;
           maxProfit = Math.max(maxProfit, cost);
           min = Math.min(prices[i], min); 
        }
        return maxProfit;
    }
}
