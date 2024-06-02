/*
So basically contruct trie with int weight instead of isWord; where weight is index of each word in words
Then iterate over words and then iterate over each word+'{' then create pointer curr to root trie and curr.weight = weight
then from another iteration j from i index till 2 * word.length so that every combination of prefix and suffix can be entered
into the trie using int k = word.chatAt(j % word.length) - 'a' doing this we get the index of char - 'a' for storing in trie
Then search function can be used to look up if combination of suffic+'{'+prefix.toCharArray() is present in the trie or not.
*/
class PrefixAndSuffixSearch {
  class TrieNode{
    TrieNode [] children;
    int weight;
    public TrieNode(){
      this.children = new TrieNode[27]; // for 26 letters + 27the '{' place
    }
  }
  TrieNode root;
  public PrefixAndSuffixSearch(){
    this.root = new TrieNode();
  }
  public void addWords(String[] words){
    for(int weight = 0; weight < words.length; weight++){
      String word = words[weight] + "{";
      for(int i = 0; i < word.length(); i++){
        TrieNode curr = root;
        curr.weight = weight;
        for(int j = i ; j < 2 * word.length(); j++){
          int k = word.charAt(j % word.length()) - 'a'; // to get index
          if(curr.children[k] == null){
            curr.children[k] = new TrieNode();
          }
          curr = curr.children[k];
          curr.weight = weight;
        }
      }
    }
  }
  public int f(String prefix, String suffix){
    TrieNode curr = root;
    for(char c: (suffix+"{"+prefix).toCharArray()){
      if(curr.children[c - 'a'] == null){
        return -1;
      }
      curr = curr.children[k];
    }
    return curr.weight;
  }
}
