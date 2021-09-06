import java.util.*;
class PopulatingNextRightPointer_2 {
  public Node connect(Node root) {
        
    if (root == null) return root;
    
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    
    
    while (!q.isEmpty()) {
        int size =q.size();
        List<Node> level = new ArrayList<>();
        for (int i=0; i<size; i++) {
            Node curr = q.poll();
            level.add(curr);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        
        for (int i=0; i<level.size()-1; i++) {
            level.get(i).next = level.get(i+1);
        }
        
        level.get(level.size()-1).next = null;
    }
    
    
    return root;
}
}