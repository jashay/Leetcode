public class MinDepthOfBinartTree {
  private void dfs(TreeNode root, int currDepth, int[] minDepth) {
        
    if (root.left == null && root.right == null) {
       minDepth[0] = Math.min(currDepth+1, minDepth[0]);
       return; 
    }
    
    if (root.left != null) {
        dfs(root.left, currDepth+1, minDepth);
    }
    
    if (root.right != null) {
        dfs(root.right, currDepth+1, minDepth);
    }   
}

  public int minDepth(TreeNode root) {
      
      int[] minDepth = new int[1];
      
      minDepth[0] = Integer.MAX_VALUE;
      
      if (root != null) {
          dfs(root, 0, minDepth);
          return minDepth[0];
      }
      else return 0;
  }
}
