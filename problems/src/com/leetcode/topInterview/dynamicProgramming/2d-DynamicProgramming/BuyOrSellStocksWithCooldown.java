class BuyOrSellStocksWithCooldown {
    // after selling need one day of cooldown
    // state either buying -> i + 1 or selling then cooldown -> i + 2
    public int maxProfit(int[] prices) {
       Map<String, Integer> hashMap = new HashMap<>();
       return dfs(0, prices, cache, true);
    }
    private int dfs(int i, int[] prices, Map<String, Integer> cache, boolean buying){
      if(i >= prices.length)
        return 0;
      String key = i + "-" + buying;
      if(cache.containsKey(key))
        return cache.get(key);
      int cooldown = dfs(i + 1, prices, cache, buying);
      int buyOrSell = Integer.MIN_VALUE;
      if(buyOrSell)
        buyOrSell = dfs(i + 1, prices, cache, !buying) - prices[i];
      else
        buyOrSell = dfs(i + 1, prices, cache, !buying) + prices[i]; // bcoz selling we add profit
      cache.put(key, Math.max(cooldown, buyOrSell);
      return cache.get(key);
    }
}
