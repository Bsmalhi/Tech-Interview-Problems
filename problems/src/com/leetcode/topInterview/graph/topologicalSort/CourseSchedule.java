class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      List<List<Integer>> adjList = new ArrayList<>();
      for(int i = 0; i < numCourses; i++){
          adjList.add(new ArrayList<>());
      }
      //build adjList for prerequisites graph
      for(int i = 0; i < prerequisites.length; i++){
          adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
      }
      Set<Integer> visited = new HashSet<>(); // to check if cycle present in current iteration of DFS if not then all courses can be completed
    for(int i = 0; i < numCourse; i++){
      if(isCycleDFS( i, adjList, visited))
         return false; // cycle found cannot complete all courses
    }
    return true;
   }
  private void isCycleDFS( int course, List<List<Integer>> adjList, Set<Integer> visited){
    if(visited.contains(course)
      return true; // cycle present
    visited.add(course);
    for(int preReq: adjList.get(course)){
      if(isCycleDFS( i, adjList, visited))
        return true; // cycle found course cannot be completed
    }
    visited.remove(course);
    returnt false; // no cycle present
  }
}
