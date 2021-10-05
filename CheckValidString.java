import java.util.*;
public class CheckValidString {
  public boolean checkValidString(String s) {
    Stack<Integer> openStack = new Stack();
    Stack<Integer> startStack = new Stack();
    
    for (int i=0; i<s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
            openStack.push(i);
        }
        else if (c == '*') {
            startStack.push(i);
        }
        else {
            if (!openStack.isEmpty()) {
                openStack.pop();
                continue;
            }
            if (!startStack.isEmpty()) {
                startStack.pop();
                continue;
            }                
            return false;
        }
    }

    while (!openStack.isEmpty()) {
        if (startStack.isEmpty()) return false;
        else {
            while(!startStack.isEmpty() && startStack.peek() < openStack.peek()) startStack.pop();
            
            if (!startStack.isEmpty()) {
                openStack.pop();
                startStack.pop();
            }
        }
    }
    
    return true;
    
}
}
