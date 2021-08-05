import java.util.*;

public class SumRootToLeaf {
  private void dfs(TreeNode root, String currSum, List<String> list) {
    if (root.left == null && root.right == null) {
        list.add(currSum+root.val);
        return;
    }
    
    if (root.left != null) {
        dfs(root.left, currSum+root.val, list);
    }
    if (root.right != null) {
        dfs(root.right, currSum+root.val, list);
    }
    
}

  public int sumNumbers(TreeNode root) {
      List<String> list = new ArrayList<>();
      dfs(root, "", list);
      
      int sum = 0;
      for (String z : list) {
          sum += Integer.parseInt(z);
      }
      
      return sum;
  }
}
