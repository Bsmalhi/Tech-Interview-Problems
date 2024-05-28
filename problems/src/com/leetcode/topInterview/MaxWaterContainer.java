class MaxWaterContainer {
  public int maxArea(int [] heights){
    int l = 0, j = heights.length - 1;
    int max = 0;
    while(l < r){
      int height = Math.min(heights[l], heights[r]);
      int area = (r - l) * height;
      max = Math.max(max, area);
      if(heights[l] > heights[r]){
        r--;
      } else {
        l++;
      }
    }
    return max;
  }
}
