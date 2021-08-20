import java.util.*;
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
        
    if (s.length() != t.length()) return false;
    
    Map<Character, Integer> map = new HashMap<>();
    
    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0)+1);
    }
    
    for (char x : t.toCharArray()) {
        if (map.containsKey(x)) {
            int count = map.get(x);
            count--;
            if (count == 0) {
                map.remove(x);
            }
            else {
                map.put(x, count);
            }
        }
        else {
            return false;
        }
    }
    
    return true;
}
}
