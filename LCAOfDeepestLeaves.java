import java.util.*;
class LCAOFDeepestLeaves {
  public TreeNode LCA(TreeNode root, List<Integer> leaves) {
    if (root == null) return null;
    
    for (int leaf : leaves) {
        if (leaf == root.val) return root;            
    }
    
    TreeNode left = LCA(root.left, leaves);
    TreeNode right = LCA(root.right, leaves);

    if (left != null && right != null) return root;
    
    if (left != null) return left;
    if (right != null) return right;
    
    return null;
}    

  public TreeNode lcaDeepestLeaves(TreeNode root) {
      
      Queue<TreeNode> q= new LinkedList<>();
      q.add(root);
      List<Integer> currLevel = new ArrayList<>();
      while (!q.isEmpty()) {
          int size = q.size();
          currLevel = new ArrayList<>();
          for (int i=0; i<size; i++) {
              TreeNode curr = q.poll();
              currLevel.add(curr.val);
              if (curr.left != null) q.add(curr.left);
              if (curr.right != null) q.add(curr.right);
          }
      }
      
      return LCA(root, currLevel);
      
  }
}