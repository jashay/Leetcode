import java.util.*;
public class AlienDictionary {
  StringBuilder sb = new StringBuilder();
    
  public boolean dfs (Map<Character, List<Character>> graph, char node, Map<Character, Boolean> visited) {

      if (visited.containsKey(node)) {
          return visited.get(node);
      }
      
      visited.put(node, false);
      for (char child : graph.get(node)) {
          if (!dfs(graph, child, visited)) return false;
      }
      visited.put(node, true);
      sb.append(node);
      return true;
  }
  
  public String alienOrder(String[] words) {
      
      Map<Character, List<Character>> graph = new HashMap<>();
      
      for (String word : words) {
          for (char c : word.toCharArray()) {
              graph.putIfAbsent(c, new ArrayList<>());
          }
      }
      
      for (int i=0; i<words.length-1; i++) {
          char[] w1 = words[i].toCharArray();
          char[] w2 = words[i+1].toCharArray();
          int len = Math.min(w1.length, w2.length);
          int x=0;
          if (w1.length > w2.length && words[i].startsWith(words[i+1])) {
              return "";
          }
          
          while (x < len) {
              if (w1[x] != w2[x]) {
                  // add to graph
                  graph.get(w1[x]).add(w2[x]);
                  break;
              }
              x++;
          }
      }

      Map<Character, Boolean> visited = new HashMap<>();
      for (char key : graph.keySet()) {
          if (!dfs(graph, key, visited)) return "";
      }
          
      
      return sb.reverse().toString();

  }
}
