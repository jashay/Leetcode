import java.util.*;
public class FindCircleNum {
  public void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int i) {
    if (visited[i] == true) return;
    
    visited[i] = true;
    List<Integer> list = map.get(i);
    for (int x : list) {
        if (visited[x] == false) {
            if (map.containsKey(x))
                dfs(map, visited, x);
            else visited[x] = true;
        }
    }
}

public int findCircleNum(int[][] isConnected) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    for (int i=0; i<isConnected.length; i++) {
        for (int j=0; j<isConnected[0].length; j++) {
            
            if (isConnected[i][j] == 1) {
                List<Integer> list;
                if (map.containsKey(i)) {
                    list = map.get(i);
                }
                else {
                    list = new ArrayList<>();
                }
                list.add(j);
                map.put(i, list);
            }
        }
    }
    int count = 0;
    int n = isConnected.length;
    boolean[] visited = new boolean[n];
    
    
    for (int x=0; x<n; x++) {
        visited[x] = false;
    }
    
    for (int i=0; i<n; i++) {
        if (visited[i] == false && map.containsKey(i)) {
            count +=1;
            dfs(map, visited, i);
        }
        else if (visited[i] == false) {
            visited[i] = true;
            count +=1;
        }
    }
    
    return count;
}
}