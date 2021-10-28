class MaxDiffBetweenNodeAndAncestor {
  int max = 0;
    
    public void dfs(TreeNode root, int maxTillNow, int minTillNow) {
        if (root == null) return;
        
        int t = Math.max(Math.abs(root.val - maxTillNow), Math.abs(root.val - minTillNow));
        max = Math.max(t, max);
        
        maxTillNow = Math.max(maxTillNow, root.val);
        minTillNow = Math.min(minTillNow, root.val);
        
        dfs(root.left, maxTillNow, minTillNow);
        dfs(root.right, maxTillNow, minTillNow);
    }
    
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return max;
    }
}