import java.util.*;
public class RemoveOuterMostParenthesis {
  public String removeOuterParentheses(String s) {
        
    int balance = 0;
    List<String> list = new ArrayList();
    StringBuilder curr = new StringBuilder();
    for (char c : s.toCharArray()) {
        curr.append(c);
        if (c == '(') {
            balance++;
        }
        else {
            balance--;
        }
        
        if (balance == 0) {
            list.add(curr.toString());
            curr = new StringBuilder();
        }
    }
    StringBuilder ans = new StringBuilder();
    for (String str : list) {
        ans.append(str.substring(1, str.length()-1));
    }
    return ans.toString();
}
}
