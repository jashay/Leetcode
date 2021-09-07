class MaxDepth {
  public void dfs(TreeNode root, int[] max, int curr) {
    if (root == null) return;
    
    max[0] = Math.max(max[0], curr);
    
    if (root.left != null) dfs(root.left, max, curr+1);
    if (root.right != null) dfs(root.right, max, curr+1);
    
}

  public int maxDepth(TreeNode root) {
      int[] max = new int[1];
      dfs(root, max, 1);
      
      return max[0];
  }

}