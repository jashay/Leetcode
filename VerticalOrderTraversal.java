import java.util.*;
public class VerticalOrderTraversal {
  class Pair {
    int balance;
    TreeNode node;
    
    Pair(TreeNode n, int b) {
        this.node = n;
        this.balance = b;
    }
}



public List<List<Integer>> verticalOrder(TreeNode root) {
    Map<Integer, List<Integer>> map = new TreeMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    
    if (root == null) return ans;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, 0));
    
    while(!q.isEmpty()) {
        int size = q.size();
        
        for (int i=0; i<size; i++) {
            Pair p = q.poll();
            List<Integer> list;
            if (map.containsKey(p.balance)) {
                list = map.get(p.balance);
            }
            else {
                list = new ArrayList<>();
            }
            list.add(p.node.val);
            map.put(p.balance, list);
            
            if (p.node.left != null) q.add(new Pair(p.node.left, p.balance -1));
            if (p.node.right != null) q.add(new Pair(p.node.right, p.balance +1));
        }
    }
    
    
    
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        ans.add(entry.getValue());
    }
    
    return ans;
  }
}
