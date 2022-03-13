import java.util.*;
public class CountAllAncestors {
    public void dfs(Map<Integer, List<Integer>> map, List<Integer> t, int curr, int o, Set<Integer> visited) {
        if (curr != o) t.add(curr);
        visited.add(curr);
        if (map.containsKey(curr)) {
            for (int next : map.get(curr)) {
                if (visited.contains(next)) continue;
                dfs(map, t, next, o, visited);
            }
        }
    }
    
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] e : edges) {
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[1]).add(e[0]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            if (map.containsKey(i)) {
                List<Integer> temp = new ArrayList<>();
                dfs(map, temp, i, i, new HashSet<>());
                Collections.sort(temp);
                ans.add(temp);
            }
            else {
                ans.add(new ArrayList<>());
            }
        }
        
        return ans;
    }
}
