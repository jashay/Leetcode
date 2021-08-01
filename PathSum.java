public class PathSum {
  public boolean checkDfs(TreeNode root, int targetSum, int currSum) {
    if (root == null) return false;
    
    currSum += root.val;
    
    if (root.left == null && root.right == null) {
        if (currSum == targetSum) return true;
        else return false;
    }
    
    return checkDfs(root.left, targetSum, currSum) || checkDfs(root.right, targetSum, currSum);
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
      return checkDfs(root, targetSum, 0);
  }
}
