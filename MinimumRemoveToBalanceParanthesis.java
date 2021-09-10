import java.util.*;
public class MinimumRemoveToBalanceParanthesis {
  public String minRemoveToMakeValid(String s) {
    boolean[] toRemove = new boolean[s.length()];
    StringBuilder sb = new StringBuilder();
    Arrays.fill(toRemove, false);
    int open = 0, close = 0;
    for (int i=0; i<s.length(); i++) {
        char c = s.charAt(i);
        if (c=='(') {
            open++;
        }
        else if (c==')') {
            if (open>0) {
                open--;
            }
            else {
                toRemove[i] = true;
            }
            
        }
    }
    
    for (int i=s.length()-1; i>=0; i--) {
        char c = s.charAt(i);
        if (c==')') {
            close++;
        }
        else if (c=='(') {
            if (close>0) {
                close--;
            }
            else {
                toRemove[i] = true;
            }
            
        }
    }
    
    
    for (int i=0; i<s.length(); i++) {
        if (!toRemove[i]) sb.append(s.charAt(i));
    }
    
    return sb.toString();
  }
}
