import java.util.*;

public class KthSmallestInBST {
  public void dfs(TreeNode root, int k, List<Integer> list) {
        
    if (root == null) return;
    
    if (root.right == null && root.left == null) {
        list.add(root.val);
        return;
    }
    
    if (root.left != null) {
        dfs(root.left, k, list);
    }
    
    list.add(root.val);
    if (list.size() == k) return;
    
    if (root.right != null) {
        dfs(root.right, k, list);
    }
}

  public int kthSmallest(TreeNode root, int k) {
      List<Integer> list = new ArrayList<Integer>();
      
      dfs(root, k, list);
      
      return list.get(k-1);
      
  }
}
