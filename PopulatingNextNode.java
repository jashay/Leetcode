import java.util.*;
public class PopulatingNextNode {
  public Node connect(Node root) {
    if (root == null) return null;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    
    while (!q.isEmpty()) {
        int size = q.size();
        List<Node> list = new ArrayList<>();
        for (int i=0; i<size; i++) {
            Node curr = q.poll();
            curr.next = null;
            list.add(curr);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        for (int i=0; i<list.size()-1; i++) {
            list.get(i).next = list.get(i+1); 
        }
    }
    
    return root;
}
}
