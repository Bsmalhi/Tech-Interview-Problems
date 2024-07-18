class DetectSquares{
    List<int[]> points;
    int[][] pointsCount;
    public CountSquares() {
        pointsCount = new int[1001][1001];
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
       pointsCount[point[0]][point[1]] += 1; // keeping count of the same points in 2d plane
       points.add(point);
    }
    // inverst always invert meaning find out a square will not form
    public int count(int[] point) {
        int result = 0;
        for(int[] p: points){
            int px = p[0], py = p[1];
            int x = point[0], y = point[1];
            if(Math.abs(px - x) != Math.abs(py - y) || (px == x && py == y)){ // can't be a square
                continue;
            }
            result += pointsCount[x][py] * pointsCount[px][y];
        }
        return result;
    }
}
