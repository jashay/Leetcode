public class RemoveDupsFromList {
  public ListNode deleteDuplicates(ListNode head) {
        
    if (head == null || head.next == null) return head;
    ListNode curr = head;
    ListNode prev = curr;
    curr = curr.next;
    
    while (curr != null) {
        if (curr.val == prev.val) {
            prev.next = curr.next;
            curr = curr.next;
        }
        else {
            curr = curr.next;
            prev = prev.next;
        }
    
    }
    
    return head;
  }
}
