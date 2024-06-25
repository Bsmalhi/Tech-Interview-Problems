class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 0)
            return false;
        int[] arr = new int[26];
        for(int i = 0; i < t.length(); i++){
            arr[t.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == 0)
                return false;
            arr[s.charAt(i) - 'a']--;
        }
        return true;
    }
}
