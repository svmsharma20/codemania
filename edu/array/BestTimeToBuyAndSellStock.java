/*
*   https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*   Time complexity: O(n)
*/

package edu.array;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        int j = prices.length-1;
        int i = 0;
        int max = 0;
        while(j>=0 && i>=0){
            while(j>0 && prices[j] < prices[j-1]){
                j--;
            }
        
            i = j-1>0 ? j-1 : 0;
            
            while(i>0 && prices[i] > prices[i-1]){
                i--;
            }
            
            if(i<j){
                max += prices[j] - prices[i];
            }
            j=i-1;
        }
        return max;
    }
}
