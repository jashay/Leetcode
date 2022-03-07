import java.util.*;
public class ConstructBSTfromPreorder {
    int prePointer = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode recurse(int[] preorder, int[] inorder, int start, int end) {
        if (prePointer == preorder.length || start > end) return null;
        TreeNode root = new TreeNode(preorder[prePointer++]);
        
        root.left = recurse(preorder, inorder, start, map.get(root.val) - 1);
        root.right = recurse(preorder, inorder, map.get(root.val) + 1, end);
        
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return recurse(preorder, inorder, 0, preorder.length-1);
    }
}
