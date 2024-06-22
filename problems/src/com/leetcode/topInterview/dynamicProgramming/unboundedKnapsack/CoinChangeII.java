class CoinChangeII {
    /*
    Input: amount = 4, coins = [1,2,3]
    Output: 4
    */
    public int change(int amount, int[] coins) {
        int [] dp = new int[amount + 1]; // amount = 4;
        // you can visualize the 2d array few times so 0th cell is initialized to 1 
        // meaning 0 amount can be reached in 1 way i.e. no coin also is a way
        dp[0] = 1; 
        for(int coin : coins){
            for(int j = coin; j <= amount; j++){
                dp[j] = dp[j] + dp[j - coin]; // j = 3 - 1 = 2
            }
        }
        return dp[amount];
    }
}
