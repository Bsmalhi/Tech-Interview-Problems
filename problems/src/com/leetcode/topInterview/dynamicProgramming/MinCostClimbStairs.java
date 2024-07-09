class Solution {
    /* bottom up programming approach
      The cost to climb from step i to the top is the cost at step i plus the minimum cost to climb from either step i+1 or step i+2
      cost[i]=cost[i]+min(cost[i+1],cost[i+2]) initialy a and b = 0 as beyond last step cost is 0.
      Then a and b are essentially pointers we use to advance every step on staircase by rotating a = b and b = temp. 
      Later return Min(a, b) to give us minCost to reach starcase if we stepped 1 or 2 steps.
    */
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for(int i = cost.length - 1; i>= 0; i-- ){
            int temp = cost[i] + Math.min(a, b);
            a = b;
            b = temp;
        }
        return Math.min(a, b);
    }
}
