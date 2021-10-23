import java.util.*;
public class RemoveInvalidParenthesis {
  List<String> ans = new ArrayList();
    
    public int minRemove(String s) {
        int open =0, toRemove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')') {
                if (open>0) open--;
                else {
                    toRemove++;
                }
            }
        }
        
        return toRemove + open;
        
    }
    
    Set<String> set = new HashSet();
    
    public void backtrack(String s, String curr, int i, int open, int minRemove) {
        
        if (i == s.length()) {
            if (open == 0 && minRemove == 0) {
                set.add(curr);
            }
            return;
        }
        
        if (minRemove < 0) return;
        
        if (s.charAt(i) == '(') {
            backtrack(s, curr + '(', i+1, open+1, minRemove);
            backtrack(s, curr, i+1, open, minRemove-1);
        } 
        else if (s.charAt(i) == ')') {
            if (open > 0) {
                backtrack(s, curr + ')', i+1, open-1, minRemove);
            } 
            backtrack(s, curr, i+1, open, minRemove-1);
        }
        else {
            backtrack(s, curr + s.charAt(i), i+1, open, minRemove);
        }
        
    }
    
    
    public List<String> removeInvalidParentheses(String s) {        
    
        int toRemove = minRemove(s);
        backtrack(s, "", 0, 0, toRemove);
        
        ans.addAll(set);
        return ans;
    }
}
