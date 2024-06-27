class ValidPalindrom{
  private boolean isValidPalindrome(String s){
    int l = 0, r = s.length() - 1;
    while(l < r){
      while(l < r && !Character.isLetterOrDigit(s.charAt(l))
            l++;
      while(l < r && !character.isLetterOrDigit(s.charAt(r))
            r++;
      if(s.charAt(l) != s.charAt(r))
        return false;
    }
    return true;
  }
}
