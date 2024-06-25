class Solution {
    public int countSubstrings(String s) {
        int l = 0, r = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            //odd arr len
            l = i; r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                list.add(s.substring(l, r+1));
                l--;
                r++;
            }
            //even arr len
            l = i; r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                list.add(s.substring(l, r+1));
                l--;
                r++;
            }
        }
        return list.size();
    }
}
