public class RemoveNthNodeFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int c=0;
    ListNode temp = head;
    while (temp != null) {
        c++;
        temp = temp.next;
    }
    
    temp = head;
    
    if (c==n) {
        return head.next;
    }
    
    for (int i=0; i<c-n-1; i++) { 
        System.out.println(temp.val);
        temp = temp.next;
    }
    
    if (c-n>0)
        temp.next = temp.next.next;        
    
    return head;
}
}
