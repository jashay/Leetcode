import java.util.*;
class CompletenessOfTree {
  public boolean isCompleteTree(TreeNode root) {
    if (root == null) return true;
    
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    boolean end = false;
    
    while (!q.isEmpty()) {
        int size = q.size();
        for (int i=0; i<size; i++) {
            TreeNode curr = q.poll();
            if (curr == null) {
                end = true;
            }
            else {
                if (end) return false;
                q.add(curr.left);
                q.add(curr.right);  
            }
             
        }

        
    }
    
    return true;
}
}