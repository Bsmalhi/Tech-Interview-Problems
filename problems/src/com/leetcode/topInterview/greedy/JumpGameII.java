class Solution {
  // 2 approach one greedy and one using DP
    public int jumpGreedy(int[] nums) {
        int minJump = 0, left = 0, right = 0;
        while(right < nums.length - 1){
            int farthestJump = 0;
            for(int i = left; i <= right; i++){
                farthestJump = Math.max(farthestJump, i + nums[i]);
            }
            left = right;
            right = farthestJump;
            minJump++;
        }

        return minJump;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }
    private int dfs(int[] nums, int position, int[] memo) {
        // Base case: if we have reached or exceeded the last position
        if (position >= nums.length - 1) {
            return 0;
        }

        // If we have already computed the result for this position, return it
        if (memo[position] != -1) {
            return memo[position];
        }

        // Determine the furthest we can jump from the current position
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        int minJumps = Integer.MAX_VALUE;

        // Explore all positions we can jump to from the current position
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            int jumps = dfs(nums, nextPosition, memo);
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }

        // Store the result in the memo array
        memo[position] = minJumps;
        return memo[position];
    }
}
