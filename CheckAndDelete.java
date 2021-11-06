import java.util.*;
public class CheckAndDelete {
  Set<Integer> set = new HashSet<>();
  List<TreeNode> ans = new ArrayList<>();
    
  public TreeNode check(TreeNode root, boolean is_root) {
      if (root == null) return null;
      
      boolean deleted = set.contains(root.val);
      
      if (is_root && !deleted) ans.add(root);
      
      root.left = check(root.left, deleted);
      root.right = check(root.right, deleted);
      
      return deleted ? null : root;
  }
    
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
      
      for (int x : to_delete) {
          set.add(x);
      }
      
      check(root, true);
      
      return ans;
  }
}
