class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int result = 0;
        int minProduct = 1, maxProduct = 1;
        for(int num: nums){
            int tmp = maxProduct * num;
            maxProduct = Math.max(num, Math.max(tmp, minProduct * num)); // max can be num or maxProduct* num or minProduct * num
            minProduct = Math.min(num, Math.min(tmp, minProduct * num)); // min can be num or maxProduct * num or minProduct * num
            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
