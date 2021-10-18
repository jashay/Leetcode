import java.util.*;
public class AllNodeDistanceKInBinaryTree {
  class Pair {
    TreeNode node;
    int dist;
    Pair(TreeNode n, int d) {
        this.node = n;
        this.dist = d;
    }
}

Map<TreeNode, TreeNode> map = new HashMap();

public void dfs(TreeNode root) {
    
    if (root == null) return;
   
    if (root.left != null) {
        map.put(root.left, root);
        dfs(root.left);
    }
    if (root.right != null) {
        map.put(root.right, root);
        dfs(root.right);
    }
}


public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> ans= new ArrayList();
    if (root == null) return ans;
    
    dfs(root);
    
    Queue<Pair> q = new LinkedList();
    q.add(new Pair(target, 0));
    
    Set<TreeNode> set = new HashSet();
    set.add(target);
    
    while(!q.isEmpty()) {
        Pair curr = q.poll();
        
        if (curr.node == null) continue;
        
        if (curr.dist == k) ans.add(curr.node.val);
        
        if (curr.node.left != null && !set.contains(curr.node.left)) {
            set.add(curr.node.left);
            q.add(new Pair(curr.node.left, curr.dist+1));
        }
        if (curr.node.right != null && !set.contains(curr.node.right)) {
            set.add(curr.node.right);
            q.add(new Pair(curr.node.right, curr.dist+1));
        }
        
        if (map.containsKey(curr.node) && !set.contains(map.get(curr.node))) {
            set.add(map.get(curr.node));
            q.add(new Pair(map.get(curr.node), curr.dist+1));
        }
    }
    
    return ans;
}
}
