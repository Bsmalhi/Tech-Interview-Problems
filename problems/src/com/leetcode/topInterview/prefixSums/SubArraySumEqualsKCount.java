class SubArraySumEqualsKCount {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, resCount = 0;
        Map<Integer, Integer> sumOccurenceMap = new HashMap<>();
        sumOccurenceMap.put(0, 1);
        for(int n: nums){
            sum += n;
            // if we chop of key from sum then k can be reached so we check sum - k in HashMap 
            // if its present than we can use the count of how many times we can use that key in result Count
            int key = sum - k;
            // can we chop off a prefix that is exactly same as key from array? if yes that use that count
            resCount += sumOccurenceMap.getOrDefault(key, 0);
            sumOccurenceMap.put(sum, sumOccurenceMap.getOrDefault(sum, 0) + 1);
        }
        return resCount;
    }
}
