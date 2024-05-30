class SubarraySumEqualsK {
  /*
  Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
  A subarray is a contiguous non-empty sequence of elements within an array.
  Brute Force way -> would be to iterate starting from i=0 and then check one by one if j=i innerloop sum equals to k if yes increment count
  Optimized solution -> uses hashMap to store the sum of contingous array in hashMap and increment the count each time that sum is encountered
  later we check if (sum - K) is present in map if yes then include the count; 
  */
      public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> sumOccurencesMap = new HashMap<>();
        for(int n: nums){
          sum += n;
          int key = sum - k;
          count += sumOccurencesMap.getOrDefault(key, 0);
          sumOccurences.put(sum, sumOccureneces.getOrDefault(sum, 0) + 1);
        }
        return count;
      }
}
