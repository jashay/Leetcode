public class CountNodesEqualSubtreeAvg {
  int count = 0;

  public int[] dfs(TreeNode root) {
      if (root == null) return new int[]{0,0};
      
      int[] left = dfs(root.left);
      int[] right = dfs(root.right);
      
      if (root.left != null && left[0] / left[1] == root.left.val) count++;
      if (root.right != null && right[0] / right[1] == root.right.val) count++; 
      
      int[] curr = new int[2];
      curr[0] = root.val + left[0] + right[0];
      curr[1] = 1 + left[1] + right[1];
      return curr;        
  }
  
  public int averageOfSubtree(TreeNode root) {
      int[] last = dfs(root);
      
      if (last[0]/last[1] == root.val) count++;
      
      return count;
  }
}
