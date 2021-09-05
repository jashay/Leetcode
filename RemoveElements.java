class RemoveElements {
  public ListNode removeElements(ListNode head, int val) {
        
    if (head == null ) return head;
    
    ListNode curr = head;
    ListNode prev = curr;
    curr = curr.next;
    
    while (curr != null) {

        if (curr.val == val) {
            prev.next = curr.next;
        }
        else {
            prev = prev.next;
        }
    
        curr = curr.next;
    }
    
    return head.val == val ? head.next:head;
}
}