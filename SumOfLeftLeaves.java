import java.util.*;
public class SumOfLeftLeaves {
  List<Integer> l = new ArrayList<>();
    
    public void dfs(TreeNode root, String type) {
        
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            if (type.equals("left"))
                l.add(root.val);
            return;
        }
        
        dfs(root.left, "left");
        dfs(root.right, "right");
        
    
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        
        dfs(root, "");
        
        int sum = 0;
        for (int x : l) {
            sum+=x;
        }
        
        return sum;
    }
}
