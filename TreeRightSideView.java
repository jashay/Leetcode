import java.util.*;

public class TreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<TreeNode> q = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    q.add(root);
    
    if (root == null) return ans;
    
    while (!q.isEmpty()) {
        int size = q.size();
        ans.add(q.get(size-1).val);
        
        // Level by level
        for (int i=0; i<size; i++) {
            TreeNode curr = q.remove(0);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }
    
    
    return ans;
  } 
}
