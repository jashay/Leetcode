public class DeleteLeavesWithKValue {
  public void dfs(TreeNode root, int target, TreeNode parent, int[] flag) {
        
    if (root == null) {
        return;
    }
    
    if (root.val == target && root.left == null && root.right == null) {
        flag[0] = 0;
        
    
        if (parent.left == root) {
            parent.left = null;
            return;
        }
        else if (parent.right == root) {
            parent.right = null;
            return;
        }
    }
    
    dfs(root.left, target, root, flag);
    dfs(root.right, target, root, flag);
}

  public TreeNode removeLeafNodes(TreeNode root, int target) {
    int[] flag = new int[1];
    flag[0] = 0;
    while (flag[0] == 0) {
        flag[0] = 1;
        if (root.val == target && root.left == null && root.right == null) return null;
        dfs(root, target, null, flag);
    }
    
    return root;
  }
}
