import java.util.*;
public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
        
    if (root == null) return root;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
            
    while(!q.isEmpty()){
        TreeNode currNode = q.poll();
        
        if(currNode.right != null){
            q.add(currNode.right);
        }
        if(currNode.left != null){
            q.add(currNode.left);
        }
        
        TreeNode tempRight = currNode.right;
        currNode.right = currNode.left;
        currNode.left = tempRight;
        
    }
    
    return root;
}
}
