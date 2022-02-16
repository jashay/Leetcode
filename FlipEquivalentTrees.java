import java.util.*;
public class FlipEquivalentTrees {
    public void dfs(TreeNode root, Map<Integer, String> map) {
        if (root == null) return;
        
        map.putIfAbsent(root.val, "");
        
        if (root.left != null) map.put(root.val, map.get(root.val) + root.left.val);
        if (root.right != null) map.put(root.val, map.get(root.val) + root.right.val);
        
        dfs(root.left, map);
        dfs(root.right, map);
        
    }
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Map<Integer, String> map1 = new HashMap<>();
        dfs(root1, map1);
        Map<Integer, String> map2 = new HashMap<>();
        dfs(root2, map2);
        
        if (map1.size() != map2.size()) return false;
        
        for (int key : map1.keySet()) {
            if (!map2.containsKey(key)) return false;
            
            String s1 = map1.get(key);
            String s2 = map2.get(key);
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();
            
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            
            String s11 = new String(arr1);
            String s22 = new String(arr2);
            
            
            if (!s11.equals(s22)) return false;
            
        }
        
        return true;
    }
}
