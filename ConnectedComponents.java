import java.util.*;
public class ConnectedComponents {
  Set<Integer> visited = new HashSet<>();
  Map<Integer, List<Integer>> graph = new HashMap<>();
  public void dfs(int node) {
      visited.add(node);
      for (int x : graph.get(node)) {
          if (visited.contains(x)) continue;
          dfs(x);
      }
  }
  
  public int countComponents(int n, int[][] edges) {
      
      
      for (int i=0; i<n; i++) {
          graph.put(i, new ArrayList<>());
      }
      
      for (int[] edge : edges) {
          graph.get(edge[1]).add(edge[0]);
          graph.get(edge[0]).add(edge[1]);
      }
      int counter =0;
      for (int key : graph.keySet()) {
          if (!visited.contains(key)) {
              counter++;
              dfs(key);
          }
      }
      
      return counter;
  }
}
