class DiameterOfBinaryTree {
  
  int max = 0;
    
  public int getMaxLength(TreeNode root) {
      if (root == null) return 0;
      
      int left = getMaxLength(root.left);
      int right = getMaxLength(root.right);
      
      max = Math.max(max, left+right);
      return Math.max(left, right)+1;
      
  }
  
  
  public int diameterOfBinaryTree(TreeNode root) {
      getMaxLength(root);
      return max;
  }
}