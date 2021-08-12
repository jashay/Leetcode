import java.util.*;
public class NAryLevelOrderTraversal {
  public List<List<Integer>> levelOrder(Node root) {
        
    if (root == null) return new ArrayList<>();
    
    List<Node> q = new ArrayList<>();
    List<List<Integer>> out = new ArrayList<>();
    q.add(root);
    while (!q.isEmpty()) {
        
        int size= q.size();
        
        for (int i=0; i<size; i++) {
            Node current = q.get(i);
            for (Node child : current.children) {
                q.add(child);
            }
        }
        List<Integer> tempList = new ArrayList<>();
        for (int i=0; i<size; i++) {
            Node temp = q.remove(0);
            tempList.add(temp.val);
        }
        
        out.add(tempList);
    }
    
    return out;
}
}