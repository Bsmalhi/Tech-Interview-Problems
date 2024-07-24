class CustomSortOrder {
    /*
        2 strings order and s. Order chars are unique and sorted in custom order
        permute the characters of s so that they match order that order was sorted
    */
    public String customSortString(String order, String s) {
        if(order.length() == s.length())
            return s;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1); // pair of char and index
        }
        StringBuilder sb = new StringBuilder();
        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count-- > 0){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char c : map.keySet()){
            int count = map.get(c);
            while(count-- > 0){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
