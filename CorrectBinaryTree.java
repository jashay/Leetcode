import java.util.*;
public class CorrectBinaryTree {
  public TreeNode correctBinaryTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int t = 0;
    while (!q.isEmpty()) {
        int size = q.size();
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<size; i++) {
            TreeNode curr = q.poll();
            set.add(curr.val);
            if (curr.right != null) {
                if (!set.contains(curr.right.val)) q.add(curr.right);
                else {
                    curr.left = null;
                    curr.right = null;
                    t = curr.val;
                    continue;
                }
            }
            if (curr.left != null) q.add(curr.left);
        }
    }
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode curr = q.poll();
        
        if (curr.left != null) {
            if (curr.left.val == t) curr.left = null;
            else q.add(curr.left);
        }
        if (curr.right != null) {
            if (curr.right.val == t) curr.right = null;
            else q.add(curr.right);
        }
    }
    
    return root;
}
}
