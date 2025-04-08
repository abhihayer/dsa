package com.example.dsa_java.dsa.leetcode;

class BTBSB_121_V1 {
    public int maxProfit(int[] prices) {

        int profit = 0;
        for(int i=prices.length-1; i>0; i--){
            if(prices[i]<=profit) continue;
            
            for(int j=0; j<i; j++) {
                profit = (prices[i] - prices[j]) > profit? 
                        (prices[i] - prices[j]): profit;
            }
        }

        return profit;
    }
}