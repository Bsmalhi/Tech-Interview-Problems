class AlienDictionary {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adjMap = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        StringBuilder output = new StringBuilder();
        
        // Initialize adjMap graph
        for(String word : words){
            for(char c : word.toCharArray()){
                adjMap.putIfAbsent(c, new ArrayList<>());
            }
        }
        
        // Find all edges and add to adjMap
        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i + 1];
            int minLength = Math.min(w1.length(), w2.length());
            
            if(w1.length() > w2.length() && w1.startsWith(w2)) // prefix check, w1 can't be a prefix of w2
                return "";
            
            for(int j = 0; j < minLength; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    // Add the first non-matching character to adjMap then break
                    adjMap.get(w1.charAt(j)).add(w2.charAt(j)); 
                    break;
                }
            }
        }
        
        // Step 2: DFS to build up the output list
        for(char c: adjMap.keySet()){ // Start from any character
            if(dfs(c, adjMap, seen, output))
                return ""; // Found cycle
        }
        
        return output.reverse().toString(); // Reverse the output to get the correct order
    }
    
    private boolean dfs(char c, Map<Character, List<Character>> adjMap, Map<Character, Boolean> seen, StringBuilder output){
        if(seen.containsKey(c))
            return seen.get(c); // If seen and true, cycle detected
        
        seen.put(c, true);
        for(char w: adjMap.get(c)){
            if(dfs(w, adjMap, seen, output))
                return true; // Found cycle
        }
        seen.put(c, false); // Mark as processed
        output.append(c);
        return false; // No cycle detected
    }
}
