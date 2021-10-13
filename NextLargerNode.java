import java.util.*;
class NextLargerNode {
  public int[] nextLargerNodes(ListNode head) {
    List<Integer> list = new ArrayList();
    Stack<Integer> stack = new Stack();

    while (head != null) {
        list.add(head.val);
        head = head.next;
    }
    int[] ans = new int[list.size()];
    for (int i=0; i<list.size(); i++) {
        while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) ans[stack.pop()] = list.get(i);
        stack.push(i);
    }
    
    
    
    return ans;
}
}