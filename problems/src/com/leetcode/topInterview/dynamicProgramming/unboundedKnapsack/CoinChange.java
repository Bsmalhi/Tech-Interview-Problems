class CoinChange{
    public int coinChange(int[] coins, int amount) {
        Map<String, Integer> cache = new HashMap<>();
        int result = dfs(0, coins, 0, amount, cache);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
  private int dfs(int i, int[] coins, int total, int amount, Map<String, Integer> cache){
    if(total == amount)
      return 0;
    if(total > amount || i == coins.length)
      return Integer.MAX_VALUE;
    String key = i + "-" + total;
    if(cache.containsKey(key))
      return cache.get(key);
    // don't include the coin
    int exclude = dfs(i + 1, coins, total, amount, cache);
    // include the coin as many times as possible
    int include = dfs(i, coins, total + coins[i], amount, cache);
    if(include != Integer.MAX_VALUE){
      include += 1;
    }
    cache.put(key, Math.min(include, exclude));
    return cache.get(key);
  }
}
