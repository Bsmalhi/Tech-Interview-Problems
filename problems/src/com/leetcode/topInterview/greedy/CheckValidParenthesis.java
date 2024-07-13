class CheckValidParenthesis{
  public boolean isValid(String s){
    Boolean[][] dp = new boolean[s.length()][s.length() + 1] // index & count of unmatched open paranthesis pair
    return dfs(s, 0, 0, dp);
  }
  // 3 possible scenarios we have 
   // one is where we can count ( increment count 
   // second is where we decrement count for every )
  // thirs is to leave count unchanged and not include any char ( or )
  private boolean dfs(String s, int i, int count, Boolean[][] dp){
    if( count < 0)
      return false;
    if( i == s.length())
      return count == 0;
    if(dp[i][count] != null)
      return dp[i][count];
    if(s.charAt(i) == '('){
      dp[i][count] = dfs(s, i + 1, count + 1, dp);
    } else if(s.charAt(i) == ')'){
      dp[i][count] = dfs(s, i + 1, count - 1, dp);
    } else if(s.charAt(i) == '*'){
      dp[i][count] = dfs(s, i + 1, count + 1, dp) || dfs(s, i + 1, count - 1, dp) || dfs(s, i + 1, count, dp);
    }
    return dp[i][count];
  }
}
