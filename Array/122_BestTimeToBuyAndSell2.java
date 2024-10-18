class Solution {
    public int maxProfit(int[] prices) {

        int totalProfit = 0;

        // We start iterating from index 1 (the second day) 
        // to compare each day's price with the previous day's price.
        for(int i=1;i<prices.length;i++){

            // This condition checks if today's price (prices[i]) 
            // is greater than yesterday's price (prices[i - 1])
            // If the condition is true, it means we can make a profit 
            // by buying the stock yesterday and selling it today.
            if(prices[i] > prices[i-1]){
                int currentProfit = prices[i] - prices[i-1];
                totalProfit = totalProfit + currentProfit;
            }

        }
        return totalProfit;
    }
}
