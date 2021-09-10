import java.util.*;
public class ValidParenthesis {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c=='{' || c=='[') {
            stack.push(c);
        }
        else {
            if (!stack.isEmpty()) {
                if (c==')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                else if (c==']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                else if (c=='}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
    
    if (stack.isEmpty()) return true;
    else return false;
}
}
