class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] s1arr = new int[26];
        
        for(char c: s1.toCharArray()){
            s1arr[c - 'a']++; 
        }
        // this is sliding window match whole s1 in s2 only iterate that much
        for(int i = 0; i <= s2.length() - s1.length(); i++){ 
            int[] s2arr = new int[26];
            for(int j = 0; j < s1.length(); j++){
                s2arr[s2.charAt(i + j) - 'a']++;
            }
            // check if in current window of s2 we can find s1
            if(match(s1arr, s2arr))
                return true;
        }
        return false;
    }
    private boolean match(int [] s1, int [] s2){
        for(int i = 0; i < 26; i++){
            if(s1[i] != s2[i])
                return false;
        }
        return true;
    }
}
