class TimeMap {
    class Pair{
        String value;
        int timestamp;
        public Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<Pair>> timeMap;
    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(timeMap.containsKey(key)){
            List<Pair> list = timeMap.get(key);
            int l = 0, r = list.size() - 1;
            while(l <= r){
                int mid = l + (r - l)/2;
                if(list.get(mid).timestamp <= timestamp ){
                    res = list.get(mid).value;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return res;
    }
}
