class SparseVector{
  Map<Integer, Integer> map;
  public SparseVector(int[] nums){
    map = new HashMap();
    for(int i = 0; i < nums.length; i++){
      map.put(i, nums[i]);
    }
  }
  public int dotProduct(SparseVector vec){
    int sum = 0;
    for(Integer key: map.keySet()){
      if(vec.containsKey(key)){
        sum += map.get(key) * vec.map.get(key);
      }
    }
    return sum;
  }
}
