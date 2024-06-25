class LongestPalindromicSubstring{
    public String longestPalindrome(String s) {
        String res = "";
        int l = 0, r = 0;
        for(int i = 0; i < s.length(); i++){
            // odd length arr use case
            l = i; r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(res.length() < s.substring(l, r+1).length()){
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }
            //even length err use case
            l = i; r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(res.length() < s.substring(l, r+1).length()){
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
