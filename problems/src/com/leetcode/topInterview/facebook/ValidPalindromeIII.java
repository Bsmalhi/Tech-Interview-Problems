class ValidPalindromeIII{
    /**
    Given a string s and an int k return true if s is a k-palindrome
    k-palindrome if it can be transformed into a palindrome by removing at most k characters from it.
    Basically we DP top down and check if string can be transformed k or less times to reach a valid palindrome
     */
    public boolean isValidPalindrome(String s, int k) {
      Integer [][] memo = new Integer[s.length()][s.length()];
      return isPalindromeDfs(s, 0, s.length() - 1, memo);
    }
  // it calculates the amount of time string needed to be transformed to reach k-palindrome
  private int isPalindromeDfs(String s, int i, int j, Integer [][] memo){
    if(i == j) // 1 char remaining 
      return 0;
    if(i == j - 1) // 2 char remaining
      return s.charAt(i) == s.charAt(j) ? 0 : 1;

    if(memo[i][j] != null)
      return memo[i][j];
    if(s.charAt(i) == s.charAt(j))
      return memo[i][j] = isPalindromeDfs(s, i + 1, j - 1, memo);

    return memo[i][j] = Math.min(isPalindromeDfs(s, i + 1, j, memo) , isPalindromeDfs(s, i, j - 1, memo);
  }
}
