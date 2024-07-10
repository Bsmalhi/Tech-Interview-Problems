class CoinChangeII{
  public int change(int amount, int[] coins) {
    int [][] memo = new int[coins.length][amount + 1];
    for(int[] arr: memo)
      Arrays.fill(arr, -1);  
    return dfs(0, coins, amount, memo);
  }
  private int dfs(int i, int[] coins, int amount, int[][] memo){
    if(amount == 0)
      return 1;
    if(i == coins.length)
      return 0;
    if(memo[i][amount] != -1)
      return memo[i][amount];
    if(coins[i] >= amount){
      memo[i][amount] = dfs(i + 1, coins, amount, memo); // skip current coin as its greater than 
      return memo[i][amount];
    }
    memo[i][amount] = dfs(i, coins, amount - coins[i], memo) + dfs(i + 1, coins, amount - coins[i], memo); calculate both include + exclude coins
    return memo[i][amount];
  }
}
