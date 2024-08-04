class ContinousSubarraySum {
    /**
    A good subarray is a subarray where:
    its length is at least two, and
    the sum of the elements of the subarray is a multiple of k.
    [4, 1, 2, 3] and 6

    if we get the accumulated sum, it looks like this [4, 5, 7, 10]
    if we make it accumulated sum % k, it looks like this [4, 5, 1, 4]
    notice that there is duplicated 4's. 
    The diffference between these two sums in theory must be a multiple of 6 since we've only been storing the num%k.
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        // if(nums.length < 2)
        //     return false;
        int prefixMod = 0;
        Map<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1); // to account for initial value of prefixMod
        for(int i = 0; i < nums.length; i++){
            prefixMod = (prefixMod + nums[i]) % k;
            if(modSeen.containsKey(prefixMod)){
                if( i - modSeen.get(prefixMod) > 1){
                    return true;
                }
            } else {
                modSeen.put(prefixMod, i);
            }
        }
        return false;
    }
}
