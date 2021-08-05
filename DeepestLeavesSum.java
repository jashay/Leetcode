import java.util.*;

public class DeepestLeavesSum {
  HashMap<Integer, Integer> map = new HashMap<>(); // (k,v) -> (maxDepth, sum of node values)
    
    private void findMaxDepth(TreeNode root, int currDepth, int[] maxDepth) {
        if (root.left == null && root.right == null) {
            maxDepth[0] = Math.max(currDepth+1, maxDepth[0]);
            if (maxDepth[0] == currDepth+1)
                map.put(maxDepth[0], map.getOrDefault(maxDepth[0], 0) + root.val);
            return;
        }
        
        if (root.left != null) findMaxDepth(root.left, currDepth+1, maxDepth);
        if (root.right != null) findMaxDepth(root.right, currDepth+1, maxDepth);
    }
    
    
    public int deepestLeavesSum(TreeNode root) {
        int[] maxDepth = new int[1];
        maxDepth[0] = 0;
        findMaxDepth(root, 0, maxDepth);
        
        int maxKey = 0;
        
        for (int key : map.keySet()) {
            maxKey= Math.max(maxKey, key);
        }
        
        return map.get(maxKey);
    }
}
