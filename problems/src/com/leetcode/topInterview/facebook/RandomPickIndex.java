// Using Reservior Sampling
class RandomPickIndex{
  int [] nums;
  Random rand;
  public RandomPickIndex(int [] nums){
    this.nums = nums;
    this.rand = new Random();
  }
  public int pick(int target){
    int count = 0;
    int result = -1;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] == target){
        count++;
        /*
        So basically rand.nextInt(count) return 0 inclusive to count exclusive num and we only update when it return 0
        The probability that rand.nextInt(count) returns 0 decreases as count increases.
        For the nth occurrence, the probability of selecting the current index is 1/n
        When the first target is found, it is chosen because there's nothing else to choose from 
        When the second target is found, there’s a 50% chance that it replaces the first one.
        When the third target is found, there’s a 33.33% chance it replaces the current selection, and so on.
        */
        if(rand.nextInt(count) == 0){
          result = i;
        }
      }
    }
    return result;
  }
}
