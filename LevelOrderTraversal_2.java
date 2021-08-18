import java.util.*;
public class LevelOrderTraversal_2 {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    Stack<List<Integer>> stack = new Stack<>();
    List<TreeNode> q = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    q.add(root);
    if (root == null) return ans;
    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        for (int i=0; i<size; i++) {
            TreeNode node = q.remove(0);
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            level.add(node.val);
        }
        stack.push(level);
    }
    
    while (!stack.isEmpty()) {
        List<Integer> l = stack.pop();
        ans.add(l);
    }
    
    return ans;
}
}
