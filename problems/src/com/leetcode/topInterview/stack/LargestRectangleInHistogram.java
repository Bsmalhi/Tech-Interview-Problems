class LargestRectangleInHistogram{
  public int largestRectangleArea(int[] heights) {
    Stack<int[]> stack = new Stack<>();
    int maxArea = 0;
    for(int i = 0; i < heights.length; i++){
      int startIndex = i;
      // if currentHeight is less than last stackHeight than we can calculate area
      while(!stack.isEmpty() && stack.peek()[1] > heights[i]){ 
        int temp [] = stack.pop();
        int index = temp[0], height = temp[1];
        maxArea = Math.max(maxArea, height * (i - index));
        startIndex = index;
      }
      stack.push(new int[]{startIndex, heights[i]);
    }
    while(!stack.isEmpty()){
      int [] temp = stack.pop();
      int index = temp[0], height = temp[1];
      maxArea = Math.max(maxArea, height * (heights.length - index));
    }
    return maxArea;
  }
}
