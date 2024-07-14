class MeetingRooms {
    // arr of meeting times with start and end
    // intervals = [(0, 30), (5, 10), (15, 20)]
    // check if person could attend all meetings without overlapping any meeting time
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return true;
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        int endTime = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            if(endTime > intervals.get(i).start)
                return false;
            else 
                endTime = intervals.get(i).end;
        }
        return true;
    }
}
