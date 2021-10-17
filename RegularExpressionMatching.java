import java.util.*;
public class RegularExpressionMatching {
  Map<String, Boolean> map = new HashMap();
    
    public boolean dfs(int i, int j, String s, String p) {
        if (map.containsKey(i+","+j)) return map.get(i+","+j);
        if (i>=s.length() && j>=p.length()) return true;
        if (j>=p.length()) return false;
        
        boolean match = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if (j+1<p.length() && p.charAt(j+1) == '*') {
            map.put(i+","+j, dfs(i, j+2, s, p) || (match && dfs(i+1, j, s, p)));
            return map.get(i+","+j);
        }
        
        if (match){
            map.put(i+","+j, dfs(i+1, j+1, s, p));
            return map.get(i+","+j);
        }
        map.put(i+","+j, false);
        return false;
        
    }
    
    
    public boolean isMatch(String s, String p) {
        return dfs(0, 0, s, p);
    }
}
