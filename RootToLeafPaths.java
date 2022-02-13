import java.util.*;
class RootToLeafPaths {
  List<String> ans = new ArrayList<>();
    
    public void dfs(TreeNode root, String currPath) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            currPath += root.val;
            ans.add(currPath);
            return;
        }
        
        if (root.left != null) dfs(root.left, currPath+root.val+"->");
        if (root.right != null) dfs(root.right, currPath+root.val+"->");
        return;
    }
    
    
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        
        return ans;
    }
}