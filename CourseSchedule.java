import java.util.*;
public class CourseSchedule {
  public boolean dfs(int curr, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        
    for (int child : graph.get(curr)) {
        if (visited.contains(child)) return false;
        visited.add(child);
        if (!dfs(child, graph, visited)) return false;
        visited.remove(child);
    }
    
    graph.put(curr, new ArrayList<>());
    
    return true;
}


public boolean canFinish(int numCourses, int[][] prerequisites) {
    
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i=0; i<numCourses; i++) graph.put(i, new ArrayList<>());
    for (int[] pre : prerequisites) {
        graph.get(pre[0]).add(pre[1]);
    }
    
    Set<Integer> visited= new HashSet<>();
    
    for (int key : graph.keySet()) {
        visited.add(key);
        if (dfs(key, graph, visited)==false) return false;
        visited.remove(key);
    }
    
    return true;
}
}
