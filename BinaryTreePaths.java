import java.util.*;

public class BinaryTreePaths {
  public void dfs(TreeNode root, String current, List<String> output) {
        
    if (root == null) {
        return;
    }
    
    if (root.left == null && root.right == null) {
        current+=String.valueOf(root.val);
        output.add(current.toString());
        return;
    }
    
    current += String.valueOf(root.val)+"->";
    
    dfs(root.left, current, output);
    dfs(root.right, current, output);
}

  public List<String> binaryTreePaths(TreeNode root) {
      
      List<String> output = new ArrayList<>();
      
      dfs(root, "", output);
      
      return output;
  }
}
