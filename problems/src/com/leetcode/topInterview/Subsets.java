class Subsets {
    // The idea is to have two conditions: 
    // One in which we will take the element into consideration, 
    // Second in which we won't take the element into consideration.    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helperDfs(nums, res, list);
        return res;
    }
    public void helperDfS(int[] nums, List<List<Integer>> res, List<Integer> list, int start){
      if(start >= nums.length){
        res.add(new ArrayList<>(list));
      }
        list.add(nums[start]); // add num and start recursion
        helperDfs(nums, res, list, start + 1);
        list.remove(list.size()-1); // remove num from consideration and start recursion
        helperDfs(nums, res, list, start + 1);
    }
