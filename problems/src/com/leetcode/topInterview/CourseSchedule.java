/*
CanFinish leetcode problem 
You are given an array prerequisites where prerequisites[i] = [a, b] 
indicates that you must take course b first if you want to take course a.
*/
class CourseSchedule {
  public boolean canFinish(int[][] prerequisites, int numCourses){
      List<List<Integer>> adjList = new ArrayList<>();
    for(int i = 0; i < numCourses; i++)
      adjList.add(new ArrayList<>()); // initialize the nested list for no. of courses
    for(int i = 0; i < prerequisites.length; i++){
      adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }
    int[] visited = new int[numCourses]; 
    for(int i = 0; i < numCourses; i++){
      if(visited[i] == 0){
        if(isCycle(adjList, visited, curr)){
         return false; 
        }
      }
    }
    return true;
  }
  private boolean isCycle(List<List<Integer>> adjList, int[] visited, int curr){
    if(visited[curr] == 2)
      return true;
    visited[curr] = 2;
    for(int neighbor: adjList.get(curr)){
      if(visited[neighbor] != 1){
        if(isCycle(adjList, visited, neighbor)){
          return true;
        }
      }
    }
    visited[curr] = 1;
    return false;
  }
}
