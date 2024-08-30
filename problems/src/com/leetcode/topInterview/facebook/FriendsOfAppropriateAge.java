class FriendsOfAppropriateAge{
      /**
    N persons on social media website. int arr ages where ages[i] is age of ith person.
    age[y] <= 0.5 * age[x] + 7 | age[y] > age[x] | age[y] > 100 && age[x] < 100
    Example 1:
    Input: ages = [16,16]
    Output: 2
    Explanation: 2 people friend request each other.

    Example 2:
    Input: ages = [16,17,18]
    Output: 2
    Explanation: Friend requests are made 17 -> 16, 18 -> 17.
     */
    public int numFriendRequests(int[] ages) {
      int left = 0, result = 0;
      int prev = 0; // to keep counter for similar ages request each other as mentioned in problem
      for(int right = 1; right < ages.length; right++){
        while(left < right && ages[left] <= 0.5 * ages[right] + 7) left ++;
        while(prev < right ** ages[right] != ages[prev]) prev++;
        //include equal ages requests in result
        if(ages[prev] == ages[right] && ages[right] > 0.5 * ages[right] + 7)
          result += right - prev;
        result += right - left; // include all valid requests from left pointer to current right pointer
      }
      return result;
    }
}
