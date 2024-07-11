class EditDistance{
// 3 operations we have to perform so that means 3 ^ n*m where n is length of strings
  public int minDistance(String word1, String word2){
    if(word1.length() == 0) // bcoz it would require these many operations to get to word2 if word1 is empty 
      return word2.length();
    if(word2.length() == 0)
      return word1.length();
    int[][] dp = new int[word1.length()][word2.length];
    for(int [] arr: dp)
      Arrays.fill(arr, -1);
    return dfs(0, 0, word1, word2, dp);
  }
  private int dfs(int i, int j, String word1, String word2, int[][] dp){
    if(i == word1.length())
      return word2.length() - j;
    if(j == word2.length())
      return word1.length() - i;
    if(dp[i][j] != -1)
      return dp[i][j];
    if(word1.charAt(i) == word2.charAt(j))
      dp[i][j] = 1 + dfs(i + 1, j + 1, s, t, dp);
    else{
      int insert = (i + 1, j, s, t, dp);
      int delete = (i, j + 1, s, t, dp);
      int replace = (i + 1, j + 1, s, t, dp);
      dp[i][j] = Math.min(insert, Math.min(delete, insert));
    }
    return dp[i][j];
  }
}
