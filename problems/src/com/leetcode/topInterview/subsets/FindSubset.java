class FindSubset{
  public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        helperDfs(nums, subsets, 0, new ArrayList<>());
        return subsets;
  }
  public void helperDfs(int [] nums, List<List<Integer>> subsets, int i, List<Integer> list){
    if(i >= nums.length){
      subsets.add(new ArrayList<>(list));
    } else {
      list.add(nums[i]); // include number
      helperDfs(nums, subsets, i + 1, list);
      list.remove(list.size() - 1); // don't include last number
      helperDfs(nums, subsets, i + 1, list);
    }
  }
}
