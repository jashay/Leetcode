import java.util.*;
public class BottomLeftValue {
  public int findBottomLeftValue(TreeNode root) {
    Stack<List<Integer>> stack = new Stack<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);        

    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        for (int i=0; i<size; i++) {
            TreeNode curr = q.poll();
            level.add(curr.val);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        
        stack.push(level);
    }
    
    List<Integer> lastLevel = stack.pop();
    
    return lastLevel.get(0);
  }
}
