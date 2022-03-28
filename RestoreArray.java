import java.util.*;
class RestoreArray {
    Set<Integer> visited = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    
    public void dfs(int node, Map<Integer, List<Integer>> map) {
        if (visited.contains(node)) return;
        
        visited.add(node);
        
        list.add(node);
        
        for (int nei : map.get(node)) {
            dfs(nei, map);
        }
    }
    
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] p : adjacentPairs) {
            int x = p[0];
            int y = p[1];
            
            if (set.contains(x)) set.remove(x);
            else set.add(x);
            if (set.contains(y)) set.remove(y);
            else set.add(y);
            
            map.putIfAbsent(x, new ArrayList<>());
            map.putIfAbsent(y, new ArrayList<>());
            
            map.get(x).add(y);
            map.get(y).add(x);
        }
        
        List<Integer> l = new ArrayList<>(set);
        int start = l.get(0);
        dfs(start, map);
        int[] ans = new int[list.size()];
        
        for (int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}
