class BinaryTreePruning {
  public TreeNode dfs(TreeNode root) {
    if (root.left == null && root.right == null) {
        if (root.val == 0) return null;
        else return root;
    }
    TreeNode node = new TreeNode(root.val);
    if (root.left != null) node.left = dfs(root.left);
    if (root.right != null) node.right = dfs(root.right);
    
    if (node.left == null && node.right == null && node.val == 0) node = null;
    
    return node;
  }

  public TreeNode pruneTree(TreeNode root) {
    if (root == null) return null;
    
    return dfs(root);
  }
}