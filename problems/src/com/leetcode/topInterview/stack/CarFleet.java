class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1)
            return 1;
        int [][] combine = new int[position.length][speed.length];
        Stack<Double> stack = new Stack<>();
        //combine position and speed
        for(int i = 0; i < position.length; i++){
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }
        Arrays.sort(combine, Comparator.comparingInt(a -> a[0]));
        // if a car collides with another car before it reaches the target it becomes one fleet
        // meaning if currTime < previousTime in stack then its counted as part of a fleet as 1
        for(int i = combine.length - 1; i >= 0; i--){
            double currTime = (double) (target - combine[i][0]) / combine[i][1];
            if(!stack.isEmpty() && currTime <= stack.peek()){
                continue;
            } else {
                stack.push(currTime);
            }
        }
        return stack.size();
    }
}
