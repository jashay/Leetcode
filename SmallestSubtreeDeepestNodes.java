import java.util.*;
class SmallestSubtreeDeepestNodes {
  public TreeNode LCA(TreeNode root, List<Integer> level) {
    if (root == null) return null;
    
    for (int x : level) {
        if (root.val == x) return root;
    }
    
    TreeNode left = LCA(root.left, level);
    TreeNode right = LCA(root.right, level);
    
    if (right != null && left != null) return root;
    
    if (left != null) return left;
    if (right != null) return right;
    
    return null;
    
}

public TreeNode subtreeWithAllDeepest(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    List<Integer> level = new ArrayList<>();
    while (!q.isEmpty()) {
        int size = q.size();
        level = new ArrayList<>();
        for (int i=0; i<size; i++) {
            TreeNode curr = q.poll();
            level.add(curr.val);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }
    //level has all the deepest nodes/leaves
    return LCA(root, level);
}
}