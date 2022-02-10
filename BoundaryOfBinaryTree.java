import java.util.*;
public class BoundaryOfBinaryTree {
  public void leftBoundary(List<Integer> l, TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) return;
    
    if (root.left != null) {
        l.add(root.val);
        leftBoundary(l, root.left);
    }
    if (root.left == null && root.right != null) {
        l.add(root.val);
        leftBoundary(l, root.right);
    }
}

public void addLeaves(List<Integer> l, TreeNode root) {
    
    if (root == null) return;
    if (root.left == null && root.right == null) {
        l.add(root.val);
        return;
    } 
    
    addLeaves(l, root.left);
    addLeaves(l, root.right);
}

public void rightBoundary(Stack<Integer> st, TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) return;
    
    if (root.right != null) {
        st.push(root.val);
        rightBoundary(st, root.right);
    }
    if (root.right == null && root.left != null) {
        st.push(root.val);
        rightBoundary(st, root.left);
    }
}

public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> list= new ArrayList<>();
    list.add(root.val);
    if (root.left != null) {
        leftBoundary(list, root.left);
    }
    
    if (root.left != null || root.right != null)
        addLeaves(list, root);
    
    Stack<Integer> stack = new Stack();
    
    if (root.right != null) {
        rightBoundary(stack, root.right);
    }
    
    while (!stack.isEmpty()) {
        list.add(stack.pop());
    }
        
    return list;
}
}
