import java.util.*;

public class AddTwoNumbers_2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    while (l1 != null) {
        st1.push(l1.val);
        l1 = l1.next;
    }
    while (l2 != null) {
        st2.push(l2.val);
        l2 = l2.next;
    }
    
    int carry = 0;
    ListNode result = new ListNode();
    ListNode temp = result;
    while (!st1.isEmpty() && !st2.isEmpty()) {
        int d1 = st1.pop();
        int d2 = st2.pop();
        
        int res = d1 + d2 + carry;
        
        if (res > 9) {
            carry = res%100 - res%10;
            carry = carry/10;
            res = res%10;
        }
        else {
            carry = 0;
        }
        temp.next = new ListNode(res);
        temp = temp.next;
    }
    
    while (!st1.isEmpty()) {
        int res = st1.pop() + carry;
        if (res > 9) {
            carry = res%100 - res%10;
            carry = carry/10;
            res = res%10;
        }
        else {
            carry = 0;
        }
        temp.next = new ListNode(res);
        temp = temp.next;
    }
    
    while (!st2.isEmpty()) {
        int res = st2.pop() + carry;
        if (res > 9) {
            carry = res%100 - res%10;
            carry = carry/10;
            res = res%10;
        }
        else {
            carry = 0;
        }
        temp.next = new ListNode(res);
        temp = temp.next;
    }
    
    if (carry > 0) {
        temp.next = new ListNode(carry);
        temp = temp.next;
    }
    
    result = result.next;
    ListNode t1 = result;
    ListNode prev = null;
    while (t1 != null) {
        ListNode tempNext = t1.next;
        t1.next = prev;
        prev = t1;
        t1 = tempNext;
    }
    result = prev;
    return result;
  }
}