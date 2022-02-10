import java.util.*;
public class CountNodes {
  public int countNodes(TreeNode root) {
        
    if (root == null) return 0;
    
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int count = 0;
    
    while (!q.isEmpty()) {
        TreeNode curr = q.poll();
        count++;
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
    }
    
    return count;
}
}
