import java.util.*;
public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    
    while (head != null) {
        if (set.contains(head)) {
            return true;
        }
        
        set.add(head);
        head = head.next;
    }
    
    return false;
}
}
