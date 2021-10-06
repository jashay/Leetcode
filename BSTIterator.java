import java.util.*;
public class BSTIterator {
  List<Integer> list;
  int index;
  
  public void inorderTraversal(TreeNode root) {
      if (root == null) return;
      
      inorderTraversal(root.left);
      list.add(root.val);
      inorderTraversal(root.right);
      
      return;
  }
  
  public BSTIterator(TreeNode root) {
      list = new ArrayList();
      index = -1;
      
      inorderTraversal(root);
  }
  
  public int next() {
      return list.get(++index);
  }
  
  public boolean hasNext() {
      if (index < list.size()-1) return true;
      else return false;
  }
}