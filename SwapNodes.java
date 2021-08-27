import java.util.*;
public class SwapNodes {
  public ListNode swapNodes(ListNode head, int k) {
    int c = 0;
    ListNode temp = head;
    int x=0, y;
    while(temp != null) {
        if (c==k-1) {
            x = temp.val;
        }
        c++;
        temp = temp.next;
    }
    
    
    if (k==c) {
        if (k==1)
            return head;
    }
    temp = head;
    
    for (int j=0; j<c-k; j++) {
        temp = temp.next;
    }
    y = temp.val;
    temp.val = x;
    
    temp = head;
    for(int i = 0; i<k-1; i++) {
        temp = temp.next;
    }
    temp.val = y;
    
    return head;
}
}
