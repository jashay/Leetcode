import java.util.*;
// Definition for a Node.
class Node {
  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int _val) {
      val = _val;
  }

  public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
  }
};

public class MaxDepthNArayTree {
  private void dfs(Node root, int[] mDepth, int currDepth) {
    if (root == null) return;
    if (root.children.isEmpty()) {
        mDepth[0] = Math.max(mDepth[0], currDepth+1);
        return;
    }
    
    for (Node child : root.children) {
        dfs(child, mDepth, currDepth+1);
    }
}


  public int maxDepth(Node root) {
      int[] mDepth = new int[1];
      mDepth[0] = 0;
      dfs(root, mDepth, 0);
      
      return mDepth[0];
  }
}
