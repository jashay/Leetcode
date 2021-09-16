import java.util.*;
public class CousinsInBinaryTree {
  public boolean isCousins(TreeNode root, int x, int y) {
    Queue<TreeNode> q = new LinkedList();
    q.add(root);
    
    while (!q.isEmpty()) {
        int size = q.size();
        Set<String> pair = new HashSet();
        Set<Integer> set = new HashSet();
        for (int i=0; i<size; i++) {
            TreeNode curr = q.poll();
            set.add(curr.val);
            if (curr.left != null && curr.right != null) {
                pair.add(curr.left.val+"_"+curr.right.val);
                q.add(curr.left);
                q.add(curr.right);
                continue;
            }
            else {
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        
        if (pair.contains(x+"_"+y) || pair.contains(y+"_"+x)) return false;
        if (set.contains(x) && set.contains(y)) return true;
        
    }
    
    return false;
}
}