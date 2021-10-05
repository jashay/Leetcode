import java.util.*;
class ReverseParenthesis {
  public String reverseParentheses(String s) {
    Stack<Character> stack = new Stack();
    
    for (char c : s.toCharArray()) {
        if (c == ')') {
            StringBuilder sb = new StringBuilder();
            while (stack.peek() != '(') sb.append(stack.pop());
            stack.pop();
            for (char x : sb.toString().toCharArray()) stack.push(x);
        }
        else stack.push(c);
    }
    
    StringBuilder ans = new StringBuilder();
    
    while (!stack.isEmpty()) {
        ans.append(stack.pop());
    }
    return ans.reverse().toString();
}
}