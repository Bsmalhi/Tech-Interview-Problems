class Solution {
    public int trap(int[] height) {
       int l = 0, r = height.length - 1;
      int maxLeft = height[l], rightMax = height[r];
      int res = 0;
      while( l < r){
        if(leftMax < rightMax){
          //bcoz leftMax is smaller we increment the left index
          l++;
          //calculate new leftMax just incase if its the smaller one
          leftMax = Math.max(leftMax, height[l]);
          // res will not be negative as leftMax will be update before this calculation to be greater or equal to height[l]
          res += leftMax - height[l];
        } else {
          r++;
          rightMax = Math.max(rightMax, height[r]);
          res += rightMax - height[l];
      }
    }
      return res;
  }
}
