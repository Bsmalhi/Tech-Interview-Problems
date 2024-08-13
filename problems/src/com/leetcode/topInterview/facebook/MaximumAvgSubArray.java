class MaximumAvgSubArray {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY, currSum = 0;
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            currSum += nums[r];
            if((r - l + 1) == k){
                maxAvg = Math.max(maxAvg, currSum / k);
                currSum -= nums[l]; // Remove the leftmost element from the sum
                l++;
            }
        }
        return maxAvg;
    }
}
