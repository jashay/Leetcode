import java.util.*;
class LargestValueInLevels {
  public List<Integer> largestValues(TreeNode root) {
    if (root == null) return new ArrayList<>();
    
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    List<Integer> ans = new ArrayList<>();
    
    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i=0; i<size; i++) {
            TreeNode curr = q.poll();
            level.add(curr.val);
            max = Math.max(max, curr.val);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        ans.add(max);
    }
    
    return ans;
    
}
}