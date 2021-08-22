import java.util.*;
public class ZizagOrderedTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
    int flag = -1;
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    q.add(root);
    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        for (int i=0; i<size; i++) {
            TreeNode curr = q.poll();
            if (curr != null) {
                level.add(curr.val);
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        
        if (!level.isEmpty()) ans.add(level);
        
    }
    
    for (List<Integer> level : ans) {
        if (flag == 1) {
            Collections.reverse(level);
        }
        flag *= -1;
    }
    
    return ans;
  }
}
