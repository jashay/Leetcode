import java.util.*;
public class RemoveDuplicatesFromString {
  class Pair {
    char ch;
    int count;
    Pair (char ch, int c) {
        this.ch = ch;
        this.count = c;
    }
}

public String removeDuplicates(String s, int k) {
    Stack<Pair> stack = new Stack();
    for (int i=0; i<s.length(); i++) {
        char c = s.charAt(i);
        if (!stack.isEmpty() && stack.peek().ch == c) {
            if (stack.peek().count == k-1) {
                stack.pop();
            }
            else {
                Pair p = stack.pop();
                stack.push(new Pair(c, p.count+1));
            }
        }
        else {
            stack.push(new Pair(c, 1));
        }
    }
    
    StringBuilder sb = new StringBuilder();
    
    while (!stack.isEmpty()) {
        Pair p = stack.pop();
        for (int i=0; i<p.count; i++) sb.append(p.ch);
    }
    
    return sb.reverse().toString(); 
}
}
