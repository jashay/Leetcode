import java.util.*;
public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    ListNode temp = head;
    Stack<ListNode> stack = new Stack<>();
    
    while (temp != null) {
        stack.push(temp);
        temp = temp.next;
    }
    
    while (!stack.isEmpty()) {
        ListNode top = stack.pop();
        
        if (top.val != head.val) {
            return false;
        }
        
        head = head.next;
    }
    
    return true;
}
}
