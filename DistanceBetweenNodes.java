import java.util.*;
public class DistanceBetweenNodes {
  public TreeNode LCA(TreeNode root, int p, int q) {
    if (root == null) return null;
    
    if (root.val == p || root.val == q) {
        return root;
    }
    
    TreeNode left = LCA(root.left, p, q);
    TreeNode right = LCA(root.right, p, q);
    
    if (left != null && right != null) return root;
    
    return left != null ? left : right;
}


public int findDistance(TreeNode root, int p, int q) {
    TreeNode ancestor = LCA(root, p, q);
    
    Queue<TreeNode> queue = new LinkedList();
    queue.add(ancestor);
    boolean found1 = false, found2 = false;
    int level = 0, ans=0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i=0; i<size; i++) {
            TreeNode curr = queue.poll();
            
            if (curr.val == p) {
                found1 = true;
                ans += level;
            }
            if (curr.val == q) {
                found2 = true;
                ans += level;
            }
            if (found1 == true && found2 == true) return ans;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        level++;
    }
    
    
    return ans;
}
}
