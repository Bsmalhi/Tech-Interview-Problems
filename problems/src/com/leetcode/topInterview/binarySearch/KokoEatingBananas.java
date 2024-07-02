class KokoEatingBananas{
    public int minEatingSpeed(int[] piles, int h) {
        // minimum is 1 banana/hr rate and max is max from piles arr
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while(left < right){
            int k = left + (right - left)/2;
            int hours = 0;
            for(int pile: piles){
                hours += Math.ceil((double) pile/k);
            }
            // if the whole piles array can be eaten with less than h hours than move right = k;
            if(hours <= h){ 
                right = k;
            } else {
                left = k + 1;
            }
        }
        return right;
    }
}
