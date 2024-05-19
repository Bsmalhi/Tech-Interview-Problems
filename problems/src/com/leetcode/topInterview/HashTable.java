/*
  Uses Node array with bucket of nodes at each index
  Also uses hashFunction to calculate index to put element in using key % capacity
*/
class HashTable {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node [] array;
    int size = 0;
    int capacity;
    public HashTable(int capacity) {
        this.array = new Node[capacity]; // its a kind of bucket 
        this.capacity = capacity;
    }
    private int hashFunction(int key){
        return key % this.capacity;
    }
    public void insert(int key, int value) {
        int index = this.hashFunction(key);
        Node node = array[index];
        if(node == null){ // no index found create new entry
            array[index] = new Node(key, value);
            size++;
        } else {
            Node prev = null;
            while(node != null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, value);
            this.size++;
        }
        if((double) this.size / this.capacity >= 0.5)
            resize();
        
    }

    public int get(int key) {
        int index = this.hashFunction(key);
        Node node = array[index];

        while(node != null){
            if(node.key == key)
                return node.value;
            node = node.next;
        }

        return -1;
    }

    public boolean remove(int key) {
        int index = this.hashFunction(key);
        Node node = array[index];
        Node prev = null;
        while(node != null){
            if(node.key == key){
                if(prev != null){  // update prev node next ptr to node.next;
                    prev.next = node.next; 
                } else { // first node in the bucket to remove point to next node
                    this.array[index] = node.next;
                }
                this.size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        Node [] newArray = new Node[2 * this.capacity];
        this.capacity = 2 * capacity;
        for(Node node: this.array){
            while(node != null){
                int index = node.key % capacity;
                if(newArray[index] == null){
                    newArray[index] = new Node(node.key, node.value);
                } else {
                    Node newNode = array[index];
                    while(newNode.next != null);
                        newNode = newNode.next;
                    newNode.next = new Node(node.key, node.value);
                }
                node = node.next;
            }
        }
        array = newArray;
    }
}
