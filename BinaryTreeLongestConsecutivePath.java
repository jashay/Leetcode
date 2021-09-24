public class BinaryTreeLongestConsecutivePath {
  int max = 0;
    
    public void dfs(TreeNode root, int currLen) {
        if (root == null) return;
        
        max = Math.max(currLen, max);
        
        if (root.left != null && root.val == root.left.val - 1)
            dfs(root.left, currLen+1);
        else dfs(root.left, 1);
        
        if (root.right != null && root.val == root.right.val -1)
            dfs(root.right, currLen+1);
        else dfs(root.right, 1);
    }
    
    
  public int longestConsecutive(TreeNode root) {
      dfs(root, 1);
      
      return max;
  }
}
