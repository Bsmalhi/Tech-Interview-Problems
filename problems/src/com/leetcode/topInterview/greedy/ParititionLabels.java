class ParititionLabels {
    // given a string s lowercase englist letters
    // split string into substring, each letter appears in at most one substring
    // return list of integers representing size of substrings in order
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){ // pair of (char, index)
            map.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int size = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
          end = Math.max(end, map.get(s.length(i)));
          size++;
          if(i == end){
            result.add(size);
            size = 0;
          }
        }
      return result;
    }
}
