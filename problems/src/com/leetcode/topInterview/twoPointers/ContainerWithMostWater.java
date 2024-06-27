class ContainerWithMostWater{
  public int heigth(int [] heights){
    int l = 0, r = heights.length -1;
    int max = 0;
    while(l < r){
      max = Math.max(max, (r - l) * Math.min(height[l], height[r]); // you can only store min height water so take min height
      if( height[l] < height[r]){
        l++;
      } else {
        r--;
      }      
    }
    return max;
  }
}
