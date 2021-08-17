import java.util.*;
public class EvalReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    
    Set<String> set = new HashSet<>();
    set.add("/");
    set.add("*");
    set.add("+");
    set.add("-");

        
    for (String str : tokens) {
        if (!set.contains(str)) {
            stack.push(Integer.parseInt(str));
        }
        else { 
            int x = stack.pop();
            int y = stack.pop();
            int ans=0;
            if (str.equals("/")) {
                ans = y/x;
            }
            else if (str.equals("+")) {
                ans = y+x;
            }
            else if (str.equals("*")) {
                ans = y*x;
            }
            else if (str.equals("-")) {
                ans = y-x;
            }
            stack.push(ans);
        }
    }

    return stack.peek();
  }
}
