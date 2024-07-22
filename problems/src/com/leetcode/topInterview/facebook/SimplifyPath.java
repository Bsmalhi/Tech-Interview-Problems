class SimplifyPath{
      /*
        Absolute path is given as String transform into simplified canonical path.
        Rules for canonical path
        1. must start with /
        2. directories only separated by slash
        3. should not end with a slash unless it's the root directory
        4. it should exclude any single or double periods used to denote current or parent directories
        logic
        - put char in stack then 
    */
    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        String[] components = path.split("/");
        for(String p : components){
          if(p.equals(".") || p.isEmpty()){
            continue;
          } else if(p.equals("..")){
            if(!queue.isEmpty())
              queue.pollLast();
          } else {
            queue.offer(p);
          }
        }
      StringBuilder res = new StringBuilder();
      for(!queue.isEmpty()){
        res.append("/");
        res.append(queue.poll());
      }
      return res.length() > 0 ? res.toString() : "/";
    }
}
