class CombinationSum {
  // Input: candidates = [2,3,6,7], target = 7
  // Output: [[2,2,3],[7]]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helperDfs(candidates, target, result, list, 0);
        return result;
    }
    public void helperDfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int index){
        if( target == 0){ // valid edge case
          result.add(new ArrayList<Integer>(list);
        } else if (index >= candidates.length || target < 0){ // invalid edge case
          return;
        } else {
          list.add(candidates[index]);
          helperDfs(candidates, target - candidates[index], result, list, index);
          list.remove(list.size() - 1);
          helperDfs(candidates, target, result, list, index + 1);
        }
    }
