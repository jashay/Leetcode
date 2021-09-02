import java.util.*;
public class OddEvenList {
  public ListNode oddEvenList(ListNode head) {
    List<Integer> list = new ArrayList<>();
    ListNode temp = head;
    if (head == null || head.next == null || head.next.next == null) return head;
    
    while (temp.next != null && temp.next.next != null) {
        list.add(temp.next.val);
        temp.next = temp.next.next;
        temp = temp.next;
    }
    // for even 
    if (temp.next != null) {
        list.add(temp.next.val);
    }
    
    for (int x : list) {
        temp.next = new ListNode(x);
        temp = temp.next;
    }
    
    return head;
}
}
