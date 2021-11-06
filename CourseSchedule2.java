import java.util.*;
public class CourseSchedule2 {
  public boolean dfs(int curr, Map<Integer, List<Integer>> graph, List<Integer> list, Map<Integer, Boolean> visited) {
    if (visited.containsKey(curr)) return visited.get(curr);
    
    visited.put(curr, false);
    for (int next : graph.get(curr)) {
        
        if (!dfs(next, graph, list, visited)) return false;
    }
    visited.put(curr, true);
    list.add(curr);
    return true;
}

public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Boolean> visited = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    
    for (int i=0; i<numCourses; i++) {
        graph.put(i, new ArrayList<>());
    }
    
    for (int[] p : prerequisites) {
        graph.get(p[1]).add(p[0]);
    }
    
    for (int x : graph.keySet()) {
        if (!visited.containsKey(x) && !dfs(x, graph, list, visited)) {
          return new int[0];
        }    
    }
    Collections.reverse(list);
    int[] ans = new int[list.size()];
    for (int i=0; i<list.size(); i++) ans[i] = list.get(i);
    return ans;
}
}
