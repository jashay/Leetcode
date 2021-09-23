public class LowestCommonAncestor2 {
  boolean flag1 = false, flag2 = false;
    
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
               
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        
        if (root.val == p.val) {
            flag1 = true;
            return root;
        }
        
        if (root.val == q.val) {
            flag2 = true;
            return root;
        }
        
        
        if (left != null && right != null) return root;
        
        if (left != null) return left;
        if (right != null) return right;
        
        return null;
        
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode c= find(root, p, q);
        if (flag1 == true && flag2 == true)
            return c;
        else 
            return null;
    }
}
