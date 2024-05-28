class PalindromeCheck {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            } 
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            r--;
            l++;
        }
        return true;
    }
}
