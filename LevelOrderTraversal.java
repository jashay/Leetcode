import java.util.*;
public class LevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<TreeNode> q = new ArrayList<>();
    q.add(root);        
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        for (int i=0; i<size; i++) {
            TreeNode node = q.remove(0);
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            level.add(node.val);
        }
        
        ans.add(level);
    }
    
    return ans;
  }
}
