import java.util.*;
class BalanceBinarySearchTree {
  public void inorder(TreeNode root, List<Integer> list) {
    if (root != null) {
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

public TreeNode balance(List<Integer> list, int left, int right) {
    if (left>right) return null;
    
    int mid = (left + right)/2;
    
    TreeNode root = new TreeNode(list.get(mid));
    root.left = balance(list, left, mid-1);
    root.right = balance(list, mid+1, right);
    
    return root;
}

public TreeNode balanceBST(TreeNode root) {
    List<Integer> list = new ArrayList();
    inorder(root, list);
    
    return balance(list, 0, list.size()-1);
}
}