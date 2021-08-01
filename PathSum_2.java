import java.util.*;

public class PathSum_2 {
  public void checkDfs(TreeNode root, int targetSum, List<List<Integer>> output, List<Integer> currentList) {
    if (root == null) return;

    currentList.add(root.val);
    
    if (root.left == null && root.right == null && root.val == targetSum) {
        output.add(new ArrayList(currentList));
    }
    else {
        checkDfs(root.left, targetSum - root.val, output, currentList);
        checkDfs(root.right, targetSum - root.val, output, currentList);
    }
    
    currentList.remove(currentList.size()-1);
}

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      List<List<Integer>> output = new ArrayList<>();
      List<Integer> cur = new ArrayList<>(); 
      checkDfs(root, targetSum, output, cur);
          
      return output;
  }
}
