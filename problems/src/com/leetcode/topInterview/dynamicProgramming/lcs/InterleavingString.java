class InterleavingString{
      // 3 strings return true if s3 formed by interleaving s1 and s2 (all lowercase)
    // difference between s1 - s2 <= 1
    // s = s1 + s2 + .... + sn
    // t = t1 + t2 + ... + tm
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length() )
            return false;
        Boolean [][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, 0, s1, s2, s3, dp);
    }
  private boolean dfs(int i, int j, s1, s2, s3, Boolean [][] cache){
        // Base case: If both i and j have reached the end of s1 and s2 respectively
        if(i == s1.length() && j == s2.length())
            return true;
        if(cache[i][j] != null)
            return cache[i][j];
        // Check if we can take a character from s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            if (dfs(i + 1, j, s1, s2, s3, cache)) {
                cache[i][j] = true;
                return true;
            }
        }
        // Check if we can take a character from s2
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            if (dfs(i, j + 1, s1, s2, s3, cache)) {
                cache[i][j] = true;
                return true;
            }
        }
        cache[i][j] = false;
        return cache[i][j];
    }  
  }
}
