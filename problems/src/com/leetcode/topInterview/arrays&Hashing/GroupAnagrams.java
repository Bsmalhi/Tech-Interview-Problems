class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int [] arr = new int[26];
            for(char c : str.toCharArray()){
                arr[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                sb.append('#');
                sb.append(arr[i]);
            }
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
