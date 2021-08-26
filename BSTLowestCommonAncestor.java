public class BSTLowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    int min = Math.min(p.val, q.val);
    int max = Math.max(p.val, q.val);
    
    while (true) {
        
        if (root == null) return null;
        
        if (min <= root.val && max >= root.val) {
            //found
            return root;
        }
        
        if (max < root.val) {
            //go left
            root = root.left;
        }
        
        if (min > root.val) {
            //go right
            root = root.right;
        }
    }
  }
}
