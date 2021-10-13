import java.util.*;
public class RemoveAllAdjacentChars {
  public String removeDuplicates(String S) {
    Stack<Character> stack = new Stack();
    
    for (char c : S.toCharArray()) {
        if (!stack.isEmpty() && stack.peek() == c) {
            stack.pop();
        }
        else {
            stack.push(c);
        }
    }
    
    StringBuilder sb = new StringBuilder();
    
    while (!stack.isEmpty()) sb.append(stack.pop());
    
    
    return sb.reverse().toString();
}
}
