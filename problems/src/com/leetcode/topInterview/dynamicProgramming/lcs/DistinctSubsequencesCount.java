class DistinctSubsequencesCount {
  /*
  Only difference here is with LCS in which we try to find largest common subsequence between s & t strings. 
  But in Distinct subsequence we find all valid subsequences of string t in string s. 
  Even empty string is valid so we return 1 j == t.length(). Also we keep a var count = 0 instead of checking only max of subsequence length.
  */
    public int numDistinct(String s, String t) {
        int [][] cache = new int[s.length() + 1][t.length() + 1];
        for(int [] arr: cache)
            Arrays.fill(arr, -1);
        return dfs(0, 0, s, t, cache);
    }
    private int dfs(int i, int j, String s, String t, int[][] cache){
        if (j == t.length()) { // even empty subsequence j empty string can be valid in s string
            return 1; // Found a valid subsequence
        }
        if (i == s.length()) {
            return 0; // No more characters in s to match
        }
        if(cache[i][j] != -1)
            return cache[i][j];
            
        int count = 0;
        if(s.charAt(i) == t.charAt(j))
            count += dfs(i + 1, j + 1, s, t, cache);

        count += dfs(i + 1, j, s, t, cache); // skip s chars only as we match s with j
        cache[i][j] = count;

        return cache[i][j];
    }
}
