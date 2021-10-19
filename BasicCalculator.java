import java.util.*;
public class BasicCalculator {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack();
    String currNumber = "";
    char op = '+';
    
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) {
            currNumber += c;
        }
        else if (c== '+' || c=='-' || c=='*' || c== '/') {
            int n = Integer.parseInt(currNumber) * ((op=='-') ? -1 : 1);
            currNumber = "";
            if (op == '*') {
                int p = stack.pop();
                n *= p;
            }
            else if (op == '/') {
                int p = stack.pop();
                p/=n;
                n = p;
            }
                
            if (c == '-') {
                op = '-';
            }
            else if (c=='+') {
                op ='+';
            }
            else if (c=='*') {
                op = '*';
            }
            else {
                op = '/';
            }
            stack.push(n);
        }
    }
    
    if (!currNumber.isEmpty()) {
        int n = Integer.parseInt(currNumber) * ((op=='-') ? -1 : 1);
        if (op == '*') {
            int p = stack.pop();
            n *=p;
        }
        else if (op=='/') {
            int p = stack.pop();
            p/=n;
            n=p;
        }
        stack.push(n);
    }
    
    
    int ans = 0;
    while (!stack.isEmpty()) {
        ans += stack.pop();
    }
    return ans;
}
}
