import java.util.*;
public class ValidateStackSequences {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Set<Integer> set = new HashSet<>();
    Stack<Integer> stack = new Stack();
    stack.push(pushed[0]);
    set.add(pushed[0]);
    if (pushed.length == 1) return true;
    
    int i=1, j=0;
    
    while (i<pushed.length) {
        if (stack.isEmpty() && i<pushed.length) {
            stack.push(pushed[i++]);
        }
        
        if (stack.peek() != popped[j]) {
            if (set.contains(popped[j])) return false;
        }
        
        while (i<pushed.length && stack.peek() != popped[j]) {
            if (set.contains(popped[j])) return false;
            stack.push(pushed[i]);
            set.add(pushed[i++]);
        }
        
        while (!stack.isEmpty() && popped[j] == stack.peek() ) {
            stack.pop();
            set.remove(popped[j]);
            j++;
        }
       
    }
    
    if (stack.isEmpty()) return true;
    else return false;
    
}
}
