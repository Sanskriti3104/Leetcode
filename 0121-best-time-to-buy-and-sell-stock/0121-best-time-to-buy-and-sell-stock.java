class Solution {
    public int maxProfit(int[] prices) {
        int MaxProfit = 0;
        int profit =0;
        int buy = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            // If the current price is greater than the buying price, calculate profit
            if(buy<prices[i]){
                profit = prices[i] - buy;
                // Update max profit if current profit is higher
                MaxProfit = Math.max(MaxProfit,profit);
            }else{
                // Update buying price if a lower price is found
                buy = prices[i];
            }
        }

        return MaxProfit;
    }
}