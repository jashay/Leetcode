import java.util.*;
public class MaxSubtreeSum {
  HashMap<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int sum = dfs(root.left)+dfs(root.right)+root.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        maxCount = Math.max(maxCount, map.get(sum));
        return sum;
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        if (root == null) return new ;
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == maxCount) {
                list.add(key);
            }
        }
            
        int[] ans = new int[list.size()];
            
        for (int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}
