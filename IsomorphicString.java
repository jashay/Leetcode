import java.util.*;
public class IsomorphicString {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    Set<Character> set = new HashSet<>();
    for (int i=0; i<s.length(); i++) {
        char x = s.charAt(i);
        char y = t.charAt(i);
        if (map.containsKey(x) && map.get(x) != y) return false;
        if (!map.containsKey(x) && set.contains(y)) return false;
        
        map.put(x,y);
        set.add(y);
    }
    
    return true;
  }
}
