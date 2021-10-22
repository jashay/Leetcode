import java.util.*;
class DiameterN_AryTree {

  class Node {
    int val;
    List<Node> children;
  }
  
  int max = 0;
  public int dfs(Node root) {
      if (root == null) return 0;
      int tempMax = 0, tempSecMax = 0;
      for (Node child : root.children) {
          int currPathLen = dfs(child);
          if (currPathLen > tempMax) {
              tempSecMax = tempMax;
              tempMax = currPathLen;
          }
          else if (currPathLen > tempSecMax) {
              tempSecMax = currPathLen;
          }
      }
      
      max = Math.max(max, tempSecMax+tempMax);
      
      return 1 + tempMax;
  }
  
  public int diameter(Node root) {
      
      dfs(root);
      
      return max;
  }
}