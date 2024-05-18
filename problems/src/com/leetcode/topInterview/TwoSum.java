class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
          int sum = nums[i] - target;
          if(map.containsKey(sum)){
            int k = map.get(sum);
            return new int[]{k, i};
          }
          map.put(sum, i);
        }
    }
}
