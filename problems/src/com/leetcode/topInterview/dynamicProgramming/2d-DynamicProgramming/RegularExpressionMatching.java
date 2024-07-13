class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
      boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
      return dfs(0, 0, s, p , dp);
    }
  private boolean dfs(int i, int j, String s, String p, boolean[][] dp) {
    if(i == s.length() && j == p.length()) // both string and regex matched
      return true;
    if(j == p.length())
      return false;
    if(dp[i][j] != false)
      return true;
    boolean match = (i < s.length() && s.charAt(i) == p.charAt(j) || p.charAt(i) == '.');
    if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
      dp[i][j] = (
        // not use * char then jump j + 2 pos to skip *
        dfs(i, j + 2, s, p, dp) ||
        // use * one or more times if current string and regex at i & j is a match
        (match && dfs(i + 1, j, s, p, dp)));
    } else { // not * char but matches then we move increment both i & j to next chars
      dp[i][j] = match && dfs(i + 1, j + 1, s, p, dp);
    }
    return dp[i][j];
  }
}
