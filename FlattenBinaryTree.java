import java.util.*;
public class FlattenBinaryTree {
  public void dfs(TreeNode root, List<Integer> list) {
    if (root == null) return;
    
    list.add(root.val);
    
    dfs(root.left, list);
    dfs(root.right, list);
    
    return;
}


  public void flatten(TreeNode root) {
      List<Integer> list = new ArrayList();
      if (root == null) return;
      dfs(root, list);
      TreeNode temp = root;
      for (int i=0; i<list.size(); i++) {
          temp.val = list.get(i);
          temp.left = null;
          if (temp.right == null && i < list.size()-1) {
              temp.right = new TreeNode();
          }
          temp = temp.right;
      }
          
  }
}
