class TargetSum{
  public int findTargetSumWays(int[] nums, int target) {
          Map<String, Integer> memo = new HashMap<>(); // to store key String of i-total, numOfways to reach target
          return numOfways(0, 0, nums, target, memo);
      }
      private int numOfways(int i, int total, int [] nums, int target, Map<String, Integer> memo){
          if(i == nums.length){
              return total == target ? 1 : 0;
          }
          String key = i + "-" + total;
          if(memo.containsKey(key))
              return memo.get(key);
              // use + and then use - total to get to to target
          memo.put(key, numOfways(i + 1, total + nums[i], nums, target, memo) + 
           numOfways(i + 1, total - nums[i], nums, target, memo));
           return memo.get(key);
  }
}
