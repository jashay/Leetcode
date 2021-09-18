public class CountGoodNodes {
  public void dfs(TreeNode root, int maxTillNow, int[] count) {
    if (root == null) return;
    
    if (root.val >= maxTillNow) count[0]++;

    dfs(root.left, Math.max(root.val, maxTillNow), count);
    dfs(root.right, Math.max(root.val, maxTillNow), count);
    
    return;
}

  public int goodNodes(TreeNode root) {
    
    if (root == null) return 0;
    
    int[] count = new int[1];
    count[0] = 0;
    dfs(root, root.val, count);
    
    return count[0];
  }
}
