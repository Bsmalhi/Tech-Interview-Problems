class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if (sum % 2 == 1) return false; // can't parition odd sum array
        sum /= 2; // bcoz this should be our target
        Boolean [][] memo = new Boolean[nums.length+1][sum + 1];
        return dfs(0, nums, sum, memo);
    }
    private boolean dfs(int i, int[] nums, int sum, Boolean[][] memo){
        if(sum == 0)
            return true;
        if(sum < 0|| i == nums.length)
            return false;
        if(memo[i][sum] != null)
            return memo[i][sum];
        // either include or not include current num
        memo[i][sum] = dfs(i + 1, nums, sum - nums[i], memo) || dfs(i + 1, nums, sum, memo);

        return memo[i][sum];
    }
}
