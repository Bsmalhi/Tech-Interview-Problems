class EncodeDecodeString {

    public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append(s);
            sb.append("#");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
          int delemiter = str.indexOf("#", i); // starting i find index of #
          int size = Integer.valueOf(str.substring(i, delemiter));
          i = size + delemiter + 1;
          result.add(str.substring(delemiter + 1, i);
        }
        return ans;
    }
}
