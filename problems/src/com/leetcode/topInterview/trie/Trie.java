class Trie{
  class TrieNode{
    TrieNode [] children;
    boolean isWord;
    public TrieNode(){
      this.children = new TrieNode[26]; // 26 possible children
    }
  }
  TrieNode trie;
  public Trie(){
    this.trie = new TrieNode();
  }
  public void insert(String word){
    TrieNode curr = trie;
    for(char c: word.toCharArray()){
      if(curr.children[c - 'a'] == null)
        curr.children[c - 'a'] = new TrieNode();
      curr = curr.children[c - 'a'];
    }
    curr.isWord = true;
  }
  public boolean search(String word){
    TrieNode curr = trie;
    for(char c: word.toCharArray()){
      if(curr.children[c - 'a'] == null)
        return false;
      curr = curr.children[c - 'a'];
    }
    if(curr.isWord)
      return true;
    return false;
  }
  public boolean startsWith(String prefix){
    TrieNode curr = trie;
    for(char c: word.toCharArray()){
      if(curr.children[c - 'a'] == null)
        return false;
      curr = curr.children[c - 'a'];
    }
    return true;
  }
}
