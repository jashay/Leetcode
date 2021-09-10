import java.util.*;
public class GenerateParenthesis {
  public void backtrack(int n, int open, int close, List<String> ans, StringBuilder curr) {
    if (curr.length() == n*2) {
        ans.add(curr.toString());
        return;
    }
    
    if (curr.length() > n*2) {
        return;
    }
    
    if (open < n) {
        curr.append("(");
        backtrack(n, open+1, close, ans, curr);
        curr.deleteCharAt(curr.length()-1);
    }
    if (close < open) {
        curr.append(")");
        backtrack(n, open, close+1, ans, curr);
        curr.deleteCharAt(curr.length()-1);
    }
    
}

  public List<String> generateParenthesis(int n) {
      List<String> ans= new ArrayList<>();
      
      backtrack(n, 0, 0, ans, new StringBuilder());
  
      
      return ans;
  }
}
