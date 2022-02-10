import java.util.*;
public class CopyListWithRandomPointer {
  class Node {
    Node random;
    Node next;
    int val;

    Node(int val) {
      this.val = val;
    }
  }
  Map<Node, Node> map = new HashMap<>();
    
  public Node copyRandomList(Node head) {
      if (head == null) return null;
      if (map.containsKey(head)) return map.get(head);
  
      Node temp = new Node(head.val);
      map.put(head, temp);
      temp.next = copyRandomList(head.next);
      temp.random = copyRandomList(head.random);
      
      return temp;
  }
}
