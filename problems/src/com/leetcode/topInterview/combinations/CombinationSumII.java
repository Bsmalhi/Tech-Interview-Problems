class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinationList = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, combinationList, new ArrayList<Integer>());
        return combinationList;
    }
    private void dfs(int[] candidates, int target, int start, List<List<Integer>> combinationList, List<Integer> list){
        if(target < 0){
            return;
        } else if(target == 0){
            combinationList.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            // skip duplicates
            if(i > start && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, combinationList, list);
            list.remove(list.size() - 1);
        }
    }
}
