public class IsSameTree {
  public boolean dfs(TreeNode p, TreeNode q) {
        
    if (p == null && q == null) return true;
    
    if (p==null || q==null || p.val != q.val) return false;
    
    return dfs(p.left, q.left) 
    && dfs(p.right, q.right);
}


  public boolean isSameTree(TreeNode p, TreeNode q) {
      return dfs(p,q);
  }
}
