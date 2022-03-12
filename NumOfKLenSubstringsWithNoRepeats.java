import java.util.*;
public class NumOfKLenSubstringsWithNoRepeats {
  public int numKLenSubstrNoRepeats(String s, int k) {
    int end = 0, start = 0;
    int count=0;
    if (k>s.length()) return 0;
    
    Map<Character,Integer> map = new HashMap<>();
    char temp;
    int dups = 0;
    for (end=0; end<s.length(); end++) {
        
        if (end-start >= k) {
            temp = s.charAt(start);
            map.put(temp, map.get(temp)-1);
            if (map.get(temp) > 0)
                dups--;
            if (map.get(temp) == 0) map.remove(temp);
            start++;
        }
        temp = s.charAt(end);
        if (map.containsKey(temp)) {
            dups++;
        }
        map.put(temp, map.getOrDefault(temp, 0)+1);
        
        if (dups == 0 && end-start+1 == k) count++;
    }
    
    
    
    return count;
}
}
