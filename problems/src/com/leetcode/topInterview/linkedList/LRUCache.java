class LRUCache {
    class ListNode {
        int key, val;
        ListNode prev;
        ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    ListNode left; // pointer to least recently used
    ListNode right; // pointer to most recently used
    int capacity;
    Map<Integer, ListNode> cache;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        left = new ListNode(0, 0);
        right = new ListNode(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        cache.put(key, new ListNode(key, value));
        insert(cache.get(key));
        if(cache.size() > capacity){
            ListNode lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void insert(ListNode node){
        ListNode prev = right.prev;
        ListNode next = right;
        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    private void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
