class ValidPalindromII {
    // check if string is Palindrome after deleting at most one char
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1; 
        while(i < j){
          if(s.charAt(i) != s.charAt(j){
            return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1); // check if its a valid palindrome
          }
          i++;
          j--;
        }
      return true;
    }
  private boolean isPalindrome(String s, int i, int j){
    while( i < j){
      if(s.charAt(i) != s.charAt(j){
        return false;
      }
      i++;
      j--;
    }
    return false;
  }
}
