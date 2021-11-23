public class AllPathsFromSourceToDEst {
  Map<Integer, Boolean> visited = new HashMap();
    
    public boolean dfs(int curr, int source, int destination, Map<Integer, List<Integer>> map) {
        if (visited.containsKey(curr)) return visited.get(curr);
        
        if (!map.containsKey(curr)) {
            if (curr == destination) return true;
            else return false;
        }
        visited.put(curr, false);
        for (int nei : map.get(curr)) {
            if (!dfs(nei, source, destination, map)) return false;
        }
        visited.put(curr, true);
        
        return true;
    }
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        Map<Integer, List<Integer>> map = new HashMap();
        
        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList());
            map.get(e[0]).add(e[1]);
        }
        
        return dfs(source, source, destination, map);
    }
}
