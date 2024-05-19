class MyHashSet {
    Bucket [] set;
    int size = 769;
    public MyHashSet() {
        this.set = new Bucket[size];
        for(int i = 0; i< size; i++)
            set[i] = new Bucket();
    }
    protected int hashFunc(int key){
        return key % size;
    }
    public void add(int key) {
        int index = hashFunc(key);
        this.set[index].insert(key);
    }
    
    public void remove(int key) {
        int index = hashFunc(key);
        this.set[index].delete(key);
    }
    
    public boolean contains(int key) {
        int index = hashFunc(key);
        return set[index].exists(key);
    }

    class Bucket{
        List<Integer> list;
        public Bucket(){
            this.list = new ArrayList<>();
        }
        public void insert(Integer key){
            int index = this.list.indexOf(key);
            if(index == -1)
                this.list.addFirst(key);
        }
        public void delete(Integer key){
            this.list.remove(key);
        }
        public boolean exists(Integer key){
            return this.list.indexOf(key) != -1 ? true : false;
        }
    }
}
