class CourseScheduleII {
    // topological sort directed graph 
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> topographCourses = new ArrayList<Integer>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>(); // to find cycle in curr of dfs
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, adjList, visited, visiting, topographCourses))
                return new int[]{};
        }
        int[] result = new int[numCourses];
        for(int i = 0; i < topographCourses.size(); i++)
            result[i] = topographCourses.get(i);
        return result;
    }
    private boolean dfs(int course, List<List<Integer>> adjList, Set<Integer> visited, Set<Integer> visiting, List<Integer> topographCourses){
        if(visited.contains(course)){
            return true;
        }
        if(visiting.contains(course))
            return false; // cycle found cannot complete all courses
        visiting.add(course);
        for(int pre: adjList.get(course)){
            if(!dfs(pre, adjList, visited, visiting, topographCourses))
                return false;
        }
        visiting.remove(course);
        visited.add(course);
        topographCourses.add(course);
        return true; // no cycle found
    }
}
