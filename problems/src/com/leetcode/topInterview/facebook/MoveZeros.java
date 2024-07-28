class MoveZeros {
    /*
        Use 2 pointers and then 2 pass. In first pass add all non zero to beginning of the array while incrementing left++ for every write.
        Second pass until left < nums.length update indexes to 0.
     */
    public void moveZeroes(int[] nums) {
        if(nums.length < 1)
            return;
        int left = 0, right = 0;
        // write all the non-zero values to the left in one pass
        for(; right < nums.length; right++){
            if(nums[right] != 0){
                nums[left++] = nums[right];
            }
        }
        // write zero for all remainging right - left indexes
        while(left < nums.length){
            nums[left++] = 0;
        }
    }
}
