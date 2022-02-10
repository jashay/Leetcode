import java.util.*;
public class GetLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return new ArrayList<>();
        q.add(root);
        List<Integer> ans= new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if (curr.left !=null) q.add(curr.left);
            if (curr.right !=null) q.add(curr.right);
            
            if (curr.left != null && curr.right == null) {
                ans.add(curr.left.val);
            }
            
            if (curr.right != null && curr.left == null) {
                ans.add(curr.right.val);
            }
        }
        
        return ans;
    }
}
