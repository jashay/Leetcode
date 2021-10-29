import java.util.*;
public class InorderSuccessor {
  List<TreeNode> list = new ArrayList();
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }
    
   
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        inorderTraversal(root);
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).val == p.val) {
                if (i+1 == list.size()) return null;
                return list.get(i+1);
            }
        }
        
        return null;
    }
}
