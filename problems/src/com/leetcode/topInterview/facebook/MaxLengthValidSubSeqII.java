class MaxLengthValidSubSeqII {
    /**
    Given int arr nums and positive int k
    subsequence sub of nums with length x is called valid if it satisfies
    (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k
    return the length of the longest valid subsequence of nums.
     */
    public int maximumLength(int[] nums, int k) {
     int dp[][] = new int[nums.length + 1][k + 1];
     int longestSeq = 0;
      for(int i = 0; i < nums.length; i++){
        for(int j = 0; j < i; j++){
          int val = (nums[i] + nums[j]) % k;
          dp[i][val] = dp[j][val] + 1;
          longestSeq = Math.max(longestSeq, dp[i][val]);
        }
      }
      return longestSeq + 1;
    }
}
