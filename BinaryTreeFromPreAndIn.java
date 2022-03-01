import java.util.*;
public class BinaryTreeFromPreAndIn {
    int prePointer = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode dfs(int iStart, int iEnd, int[] preorder, int[] inorder) {
        if (iStart > iEnd ) return null;
        
        TreeNode root = new TreeNode();
        if (prePointer < preorder.length) root.val = preorder[prePointer++]; 
        else return null;
        
        root.left = dfs(iStart, map.get(root.val) - 1, preorder, inorder);
        root.right = dfs(map.get(root.val) + 1, iEnd, preorder, inorder);
        
        return root;
        
    }
     
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++) map.put(inorder[i],i);
        
        return dfs(0, inorder.length-1, preorder, inorder);
    }
}
