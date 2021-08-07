import java.util.*;
public class AllPathsFromSourceToTarget {
  private void dfs(int[][] graph, int current, List<String> ans, String currPath) {       
        
    if (current == graph.length-1) {
        currPath+=","+current;
        ans.add(currPath);
        return;
    }
    
    for (int x=0; x<graph[current].length; x++) {
        dfs(graph, graph[current][x], ans, currPath+","+current);
    }
    
    return;
}

public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    
    List<String> ans = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    dfs(graph, 0, ans, "");
    
    for (String path : ans) {
        List<Integer> l = new ArrayList<>();
        String[] pathArray = path.split(",");
        for (String s : pathArray) {
            if (!s.equals(""))
                l.add(Integer.parseInt(s));
        }
        res.add(l);
    }
    
    return res;
    
  }
}
