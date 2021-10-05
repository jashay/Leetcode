import java.util.*;
public class DecodeString {
  public String decodeString(String s) {
    Stack<Character> stack = new Stack();
    
    for (char c : s.toCharArray()) {
        if (c != ']') {
            stack.push(c);
        }
        else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '[') {
                sb.append(stack.pop());
            }
            stack.pop();
            int n;
            StringBuilder num = new StringBuilder();
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                num.append(stack.pop());
            }
            num = num.reverse();
            sb = sb.reverse();
            n = Integer.parseInt(num.toString());
            for (int i=0; i<n; i++) {
                for (char x : sb.toString().toCharArray()) stack.push(x);
            }
        }
    }
    
    StringBuilder a = new StringBuilder();
    
    while (!stack.isEmpty()) {
        a.append(stack.pop());
    }
    
    return a.reverse().toString();
}
}
