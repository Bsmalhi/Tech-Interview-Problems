class MaxConsecutiveOnes {
    /*
        Given a binary array and k integer return max of consecutive 1's
        2 pointer problem we can start left and right we can increase window or keep max size but never reduce window size
    */
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        for(; r < nums.length; r++){
            // Since k is the maximum zeros allowed in a window.
            if(nums[r] == 0){
                k--;
            }
            // negative k denotes we have consumed all allowed flips and window has more than allowed zeros.
            // thus increment left pointer.
            if(k < 0){
                // If the left element to be thrown out is zero we increase k.
                if(nums[l] == 0)
                    k++;
                l++;
            }
        }
        return r - l;
    }
}
