import java.util.*;
public class GraphBipartite {
  class Pair {
    int v;
    int co;
    
    Pair(int v, int c) {
        this.v = v;
        this.co = c;
    }
    
}
public boolean isBipartite(int[][] graph) {
    Queue<Pair> q = new LinkedList<>();
    Map<Integer, Integer> visited  = new HashMap<>();
    
    for (int j=0; j<graph.length; j++) {
        if (visited.containsKey(j)) continue;
        int currCol = 1;
        q.add(new Pair(j, 1));
        visited.put(j, 1);
        
        while (!q.isEmpty()) {
            int size = q.size();
            currCol *= -1;
            for (int i=0; i<size; i++) {
                Pair p = q.poll();
                for (int x : graph[p.v]) {
                    if (visited.containsKey(x)) {
                        if (visited.get(x) == -currCol) return false;
                        continue;
                    }
                    visited.put(x, currCol);
                    q.add(new Pair(x, currCol));
                }
            }
        }
    }
    
    return true;
}
}
