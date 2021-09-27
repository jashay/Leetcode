public class BinaryTreeMaxPathSum {
  int max = Integer.MIN_VALUE;
    
  public int dfs(TreeNode root) {
      if (root == null) return 0;
      
      int leftMax = Math.max(0, dfs(root.left));
      int rightMax = Math.max(0, dfs(root.right));
      
      max = Math.max(max, leftMax+rightMax+root.val);
      
      return root.val + Math.max(leftMax, rightMax);
      
      
  }
  public int maxPathSum(TreeNode root) {
      int max_path = dfs(root);
      return max;
  }
}
