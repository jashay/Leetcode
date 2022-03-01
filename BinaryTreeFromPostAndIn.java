import java.util.*;
public class BinaryTreeFromPostAndIn {
    int[] postorder;
    int[] inorder;
    int postPointer;
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode dfs(int iStart, int iEnd) {
        if (iStart > iEnd ) return null;
        
        TreeNode root = new TreeNode();
        if (postPointer >=0) root.val = postorder[postPointer]; 
        else return null;
        
        postPointer--;        
        root.right = dfs(map.get(root.val) + 1, iEnd);
        root.left = dfs(iStart, map.get(root.val) - 1);
        
        return root;
        
    }
     
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i=0; i<inorder.length; i++) map.put(inorder[i],i);
        this.inorder = inorder;
        this.postorder = postorder;
        this.postPointer = postorder.length-1;
        return dfs(0, inorder.length-1);
    }
}
