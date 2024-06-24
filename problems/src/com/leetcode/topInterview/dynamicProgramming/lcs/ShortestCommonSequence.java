class ShortestCommonSequence {
  /* 
    iterative solution the idea is to build a DP table where dp[i][j] represents the length of the shortest 
    common supersequence (SCS) of the substrings str1[0...i-1] and str2[0...j-1]
    If the characters str1[i-1] and str2[j-1] match, the SCS includes this character.
    If they do not match, the SCS can either exclude str1[i-1] or str2[j-1], so take the minimum of the two possible lengths plus one.
  */
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i <= str1.length(); i++){
            for(int j = 0; j <= str2.length(); j++){
                if(i == 0){
                    memo[i][j] = j; // because the SCS of any substring of str1 and an empty str2 is the substring itself.
                } else if (j == 0){
                    memo[i][j] = i; // because the SCS of any substring of str2 and an empty str1 is the substring itself.
                } else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + 1;
                }
            }
        }
        // reconstruct the shortest common subsequence
        StringBuilder sb = new StringBuilder();
        int i = str1.length(), j = str2.length();
        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                sb.append(str1.charAt(i - 1));
                i--; j--;
            } else if(memo[i - 1][j] < memo[i][j - 1]){ // if memo i has min then append that to sb 
                sb.append(str1.charAt(i - 1));
                i--;
            } else{
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        while(i > 0){
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while(j > 0){
            sb.append(str2.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }
    public String shortestCommonSupersequence1(String str1, String str2) {
        String[][] memo = new String[str1.length() + 1][str2.length() + 1];
        return dfs(0, 0, str1, str2, memo);
    }
    private String dfs(int i, int j, String str1, String str2, String[][] memo) {
        // Base cases
        if (i == str1.length()) {
            return str2.substring(j); // Append remaining part of str2
        }
        if (j == str2.length()) {
            return str1.substring(i); // Append remaining part of str1
        }

        // Check if result is already computed
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // If characters match, include this character and move both indices forward
        if (str1.charAt(i) == str2.charAt(j)) {
            memo[i][j] = str1.charAt(i) + dfs(i + 1, j + 1, str1, str2, memo);
        } else {
            // Explore both possibilities and choose the shorter result
            String option1 = str1.charAt(i) + dfs(i + 1, j, str1, str2, memo);
            String option2 = str2.charAt(j) + dfs(i, j + 1, str1, str2, memo);
            if (option1.length() < option2.length()) {
                memo[i][j] = option1;
            } else {
                memo[i][j] = option2;
            }
        }

        return memo[i][j];
    }
}
