class LRUCache {
  public class Node {
    int key, val;
    Node next;
    Node prev;
    public Node(int key, int val){
      this.key = key;
      this.val = val;
    }
  }
    Node left;  // pointer to least recently used
    Node right;  // pointer to most recently used
    int capacity;
    Map<Integer,Node> cache;
  
  public LRUCache(){
    cache = new HashMap<>();
    left = new Node(0);
    right = new Node(0);
    left.next = right;
    right.prev = left;
  }
   public int get(int key) {
     if(cache.containsKey(key)){
       remove(cache.get(key)); // remove key so that it can be refreshed in queue to be most recent
       insert(cache.get(key)); // insert at right most recent used position
       return cache.get(key);
     }
     return -1;
   }
  public void put(int key, int value){
    Node node = new Node(key, value);
    if(cache.containsKey(key))
      remove(cache.get(key));
    cache.put(key, node);
    insert(cache.get(key));
    if(cache.size() > this.capacity){
      Node lru = this.left.next;
      remove(lru);
      cache.remove(lru.key);
    }
  }
  private void insert(Node node){ // insert from right
    Node next = right;
    Node prev = right.prev;
    next.prev = node;
    prev.next = node;
    node.next = next;
    node.prev = prev;
  }
  private void remove(Node node){
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
}
