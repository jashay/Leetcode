import java.util.*;
public class BinaryTreeFromDesc {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        
        for (int[] d : descriptions) {
            int p = d[0];
            int c = d[1];
            
            TreeNode parent;
            if (map.containsKey(p)) {
                parent = map.get(p);
            }
            else {
                parent = new TreeNode(p);
            }
            TreeNode child;
            if (map.containsKey(c)) {
                child = map.get(c);
            }
            else {
                child = new TreeNode(c);
            }
            set.add(c);
            if (d[2] == 1) parent.left = child;
            else parent.right = child;
            
            map.put(p, parent);
            map.put(c, child);
        }
        int r=-1;
        for (int key : map.keySet()) {
            if (!set.contains(key)) {
                r = key;
                break;
            }
        }
        
        return map.get(r);
        
    }
}
