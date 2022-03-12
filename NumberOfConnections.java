import java.util.*;
public class NumberOfConnections {
  Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited  = new HashSet<>();
    
    public void dfs(int x) {
        visited.add(x);
        
        for (int nei : graph.get(x)) {
            if (!visited.contains(nei)) dfs(nei);
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) return -1;
        
        for (int i=0; i<n; i++) graph.put(i, new ArrayList<>());
        
        for (int[] con : connections) {
            int x = con[0];
            int y = con[1];
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        int count = 0;
        
        for (int i=0; i<n; i++) {
            if (!visited.contains(i)) {
                dfs(i);
                count++;
            }
        }
        
        return count-1;
    }
}
