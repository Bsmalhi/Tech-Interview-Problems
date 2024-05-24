class MaximumSubarray{
  // max of subarray using Kadane's algorithm
  public int maxSum(int[] arr){
    int max = arr[0];
    int currSum = 0;
    for(int i = 0; i < arr.length; i++){
      currSum = Math.max(currSum, 0);
      currSum += arr[i];
      max = Math.max(max, currSum);
    }
    return max;
  }

  public int maxSumIndex(int [] arr){
    int max = arr[0];
    int currSum = 0;
    int Lmax = 0, Rmax = 0;
    int l = 0, r = 0;
    
    while(r < arr.length){
      if(currMax < 0){
        currMax = 0;
        l = r;
      }
      currSum += arr[r];
      if(currSum > max){
        max = currSum;
        Lmax = l;
        Rmax = r;
      }
      r++;
    }
    return new int[]{Lmax, Rmax};
  }
}
