public class PathSum3 {
  public int checkDfs(TreeNode root, int targetSum) {
    if (root == null) return 0;       
    return (root.val == targetSum ? 1: 0) + checkDfs(root.left, targetSum - root.val) +
        checkDfs(root.right, targetSum - root.val);
}

  public int pathSum(TreeNode root, int targetSum) {
      if (root == null) return 0;
      return checkDfs(root, targetSum) + pathSum(root.left, targetSum)+ pathSum(root.right, targetSum);
  }
}
