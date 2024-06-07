class CombinationSum {
  public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> combinations = new ArrayList<>();
    helperDfs(nums, 0, target, combinations, new ArrayList<Integer>());
    return combinations;
  }
  private void helperDfs(int [] nums, int target, int i, List<List<Integer>> combinationSums, List<Integer> list){
        if( target < 0 || i >= nums.length){
            return;
        } else if(target == 0){
            combinationSums.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helperDfs(nums, target - nums[i], i, combinations, list);
        list.remove(list.size() -1);
        helperDfs(nums, target, i + 1, combinations, list);
  }
}
