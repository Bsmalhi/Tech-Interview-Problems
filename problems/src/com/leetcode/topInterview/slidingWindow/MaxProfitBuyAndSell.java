class MaxProfitBuyAndSell {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, currPrice = Integer.MAX_VALUE;
        for(int n: prices){
            currPrice = Math.min(currPrice, n);
            maxProfit = Math.max(maxProfit, n - currPrice);
        }
        return maxProfit;
    }
}
