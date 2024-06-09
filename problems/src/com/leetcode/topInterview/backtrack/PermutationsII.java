class Permutations{
  /*
  This problem contains duplicate nums in array so we need to utilize those and create unique permutations
  Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
  Input: nums = [1,1,2]
  Output: [[1,1,2],[1,2,1],[2,1,1]]
  */
  public List<List<Integer>> permute(int[] nums){
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    helperDfs(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
    return result;
  }
  private void helperDfs(int[] nums, List<List<Integer>> result, List<Integer> list, int[] visited){
    if(list.size() == nums.length){
      result.add(new ArrayList<>(list));
      return;
    }
    for(int i = 0; i < nums.length; i++){
      if(visited[i] || (i > 0 && nums[i - 1] == nums[i] && visited[i - 1])// skip if already visited
         continue;
      visited[i] = true;
      list.add(nums[i]);
      helperDfs(nums, result, list, visited);
      visited[i] = false;
      list.remove(list.size() - 1);
    }
  }
}
