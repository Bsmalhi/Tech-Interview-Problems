class KDiffPairsInArray {
    // array int nums and int k
    // return unique k-diff pairs in array i.e k = 2 then 2 diff pairs
    // i != j
    public int findPairs(int[] nums, int k) {
        if(nums.length < 1)
            return 0;
        int countPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for(int i = 0; i < nums.length; i++){
            // nums[i] + k check in map and nums[i] + k != i for case where k = 0 we don't want index
            if(map.containsKey(nums[i] + k) && map.get(nums[i] + k) !=  i){
                countPairs++;
                map.remove(nums[i] + k);
            }
        }
        return countPairs;
    }
}
