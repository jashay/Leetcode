import java.util.*;
public class FindLeavesOfBinaryTree {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> ans=new ArrayList();
    while (root != null) {
        Deque<TreeNode> q = new LinkedList();
        q.addLast(root);
        List<Integer> currLeaves = new ArrayList();
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) {
                    currLeaves.add(curr.val);
                    ans.add(currLeaves);
                    return ans;
                }
                else { 
                    if (curr.left != null) {
                        if (curr.left.left == null && curr.left.right == null) {
                            currLeaves.add(curr.left.val);
                            curr.left = null;
                        }
                        else
                            q.addLast(curr.left);                            
                    }
                    if (curr.right != null) {
                        if (curr.right.left == null && curr.right.right == null) {
                            currLeaves.add(curr.right.val);
                            curr.right = null;
                        }
                        else 
                            q.addLast(curr.right);
                    }   
                }
            }
        }
        
        ans.add(currLeaves);
    }
    
    return ans;
}
}
