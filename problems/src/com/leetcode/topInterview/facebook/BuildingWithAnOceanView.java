class BuildingWithAnOceanView {
    /*
        n buildings in a line given an integer array heights of size n
        a building has an ocean view if all the buildings to its right have a smaller height.
        Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
        invert situation
        - if buildings is greater at i = than 
    */
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        list.add(heights.length - 1);
        int high = heights[heights.length - 1];
        for(int i = heights.length - 2; i >= 0; i--){
            if(heights[i] > high){
                list.add(i);
            }
            high = Math.max(high, heights[i]);
        }
        int[] result = new int[list.size()];
        int j = 0;
        for(int i = list.size() - 1; i >= 0; i--){
            result[j++] = list.get(i);
        }
        return result;
    }
}
