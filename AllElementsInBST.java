import java.util.*;
public class AllElementsInBST {
  public void inorder(TreeNode root, List<Integer> l) {
    if (root != null) {
        inorder(root.left, l);
        l.add(root.val);
        inorder(root.right, l);
    }
}

public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
    List<Integer> ans = new ArrayList();
    int x = 0, y=0;
    
    while (x < l1.size() && y < l2.size()) {
        if (l1.get(x) <= l2.get(y)) {
            ans.add(l1.get(x++));
        }
        else {
            ans.add(l2.get(y++));
        }
    }
    
    while (x < l1.size()) {
        ans.add(l1.get(x++));
    }
    
    while (y < l2.size()) {
        ans.add(l2.get(y++));
    }
    
    
    return ans;
}

public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new ArrayList();
    List<Integer> list2 = new ArrayList();
    
    inorder(root1, list1);
    inorder(root2, list2);
    
    List<Integer> list = merge(list1, list2);
    
    return list;
}
}
