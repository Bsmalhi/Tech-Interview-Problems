// not too dificult just needs some understanding that we are trying to find minStep by changing exactly one char at a time
// from beginWord to reach endWord from the wordList. In order to do that we build a AdJMap graph of String(wildcard-*), List<String>
// then after building adjMap graph perform BFS using set and queue from beginword to see if we can reach endWord if yes return minStep or 0.
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Map<String, ArrayList<String>> map = new HashMap<>();
        wordList.add(beginWord); // as wordList doesn't contains beginWord
        // Build adjMap for wildcard * string -> list<String> Map
        for(String word: wordList){
            StringBuilder sb = null;
            for(int i = 0; i < word.length(); i++){
                sb = new StringBuilder(word);
                // update exactly one position and 
                sb.setCharAt(i, '*');
                ArrayList<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
                if(list.contains(word))
                    continue;
                list.add(word);
                map.put(sb.toString(), list);
            }
        }
        // we perform BFS on AdjMap to check if we can mind minStep to obtain the endWord
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int minStep = 1; // as we already processed beginword step
        while(!queue.isEmpty()){
            minStep++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String temp = queue.poll();
                StringBuilder sb = null;
                for(int j = 0; j < temp.length(); j++){
                    sb = new StringBuilder(temp);
                    sb.setCharAt(j, '*');
                    for(String w : map.get(sb.toString())){
                        if(w.equals(endWord))
                            return minStep;
                        if(visited.contains(w))
                            continue;
                        visited.add(w);
                        queue.offer(w);
                    }
                }
            }
        }
        return 0;
    }
}
