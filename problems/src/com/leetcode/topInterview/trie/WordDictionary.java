class WordDictionary {
    class TrieNode{
      TrieNode [] children;
      boolean isWord;
      public TrieNode(){
        this.children = new TrieNode();
      }
    }
    public void addWord(String s){
      TrieNode curr = trie;
      for(char c : s.toCharArray()){
        if(curr.children[c - 'a']){
          curr.children[c - 'a'] = new TrieNode();
        }
        curr = curr.children[c - 'a'];
      }
      curr.isWord = true;
    }
  public boolean search(String word){
    return search(word, 0, trie);
  }
  
  public boolean search(String word, int index, TrieNode trie){
    TrieNode curr = trie;
    for(int i = index; i < word.length(); i++){
      char c = word.charAt(i);
      // if c == '.' then we iterate all children of curr TrieNode 
      // and check if next char after '.' in word matches true or return false
      if(c == '.'){
        for(TrieNode child: trie.children){
          if(child != null && search(word, i+1, child)
             return true;
        }
        return false;
      } else {
        if(curr.children[c - 'a'] == null){
          return false;
        }
        curr = curr.children[c - 'a'];
      }
    }
    return curr.isWord;
  }
}
