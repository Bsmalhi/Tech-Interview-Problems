class 3SumClosest {
    // arr of int length n and target given
    // find three int in nums such that sum equals target
    // so we update the closest if target - sum < closest
    // then we have to return the sum which is closest to target so do return target - closest
    public int threeSumClosest(int[] nums, int target) {
        int i = 0;
        int closest = Integer.MAX_VALUE;
       for(int i = 0; i < nums.length && closest != 0; i++){
         int j = i + 1;
         int k = nums.length - 1;
         while(j < k){
           int sum = nums[i] + nums[j] + nums[k];
           if(Math.abs(target - sum) < Math.abs(closest)){
             closest = target - sum;
           }
           if(sum > target){
             k--;
           } else {
             j++;
           }
         } 
       }
      // bcoz we need to return the closest sum from target so we substract target - closest to get that sum
      return target - closest;
    }
}
