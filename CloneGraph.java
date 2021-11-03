import java.util.*;
public class CloneGraph {
  class Node {
    int val;
    List<Node> neighbors;

    Node (int v) {
      this.val = v;
      this.neighbors = new ArrayList<>();
    }
  }
  Map<Node, Node> map = new HashMap<>();
  public Node cloneGraph(Node node) {
      
      if (node == null) return node;
      
      if (map.containsKey(node)) return map.get(node);
      
      Node clone = new Node(node.val);
      map.put(node, clone);
      
      for (Node nei : node.neighbors) {
          clone.neighbors.add(cloneGraph(nei));
      }
      
      return clone;
      
  }
}
