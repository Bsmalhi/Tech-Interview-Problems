class MeetingRoomsII{
  // need to find out min no. of rooms needed to complete all meetings
  public int rooms(int[][] intervals){
    if(intervals.length <= 1)
        return intervasl.length;
    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];
    int i = 0;
    for(int [] arr: intervals){
      start[i] = arr[0];
      end[i++] = arr[1];
    }
    i = 0;
    int j = 0, minRooms = 0, count = 0;
    while(i < intervals.length){
      if(start[i] < end[j]){ // if start of new meeting is less than end of previous meeting we need extra rooms so increment count
        count++;
        i++;
      } else {
        count--;
        j++;  
      }
      minRooms = Math.max(minRooms, count);
    }
    return minRooms;
  }
}
