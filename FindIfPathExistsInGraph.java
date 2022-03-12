import java.util.*;
class FindIfPathExistsInGraph {
  public boolean validPath(int[][] edges, int start, int end) {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
        map.putIfAbsent(edge[0], new ArrayList<>());
        map.get(edge[0]).add(edge[1]);
        map.putIfAbsent(edge[1], new ArrayList<>());
        map.get(edge[1]).add(edge[0]);
    }
    
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    
    while (!q.isEmpty()) {
        int curr = q.poll();
        if (visited.contains(curr)) continue;
        
        if (curr == end) return true;
        visited.add(curr);
        
        if (map.containsKey(curr)) {
            for (int nei : map.get(curr)) {
                q.add(nei);
            }
        }
    }
    
    return false;
}
}