class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int top = 0, bottom = row - 1;
        while(top <= bottom){
            int mid = top + (bottom - top)/2;
            if(matrix[mid][0] > target){
                bottom = mid - 1;
            } else if(matrix[mid][col - 1] < target){
                top = mid + 1;
            } else {
                break;
            }
        }
        if(top > bottom)
            return false;
        row = top + (bottom - top) / 2;
        int left = 0, right = col - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[row][mid] > target){
                right = mid - 1;
            } else if(matrix[row][mid] < target){
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
