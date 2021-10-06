import java.util.*;
public class SimplifyPath {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack();
    String[] components = path.split("/");
    
    for (String curr : components) {
        if (curr.equals(".") || curr.isEmpty()) continue;
        else if (curr.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        else {
            stack.push(curr);
        }
    }
    StringBuilder ans = new StringBuilder();
    if (stack.isEmpty()) return "/";
    for (int i=0; i<stack.size(); i++) ans.append("/"+stack.get(i));
    
    return ans.toString();
}
}
