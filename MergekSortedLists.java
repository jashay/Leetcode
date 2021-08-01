import java.util.*;

public class MergekSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    Queue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
    
    for (ListNode node : lists) {
        if (node != null)
            minHeap.offer(node);
    }
    
    ListNode output = new ListNode();
    ListNode temp = output;
    
    while (!minHeap.isEmpty()) {
        ListNode currentMin = minHeap.poll();
        
        temp.next = currentMin;
        temp = temp.next;
        
        if (currentMin.next != null) {
            minHeap.offer(currentMin.next);
        }
    }
    
    return output.next;
    
  }
}
