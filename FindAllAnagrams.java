import java.util.*;
public class FindAllAnagrams {
  public List<Integer> findAnagrams(String s, String p) {
    int len = p.length();
    List<Integer> ans = new ArrayList<>();
    int end = 0, start = 0;
    int[] chars = new int[26];
    
    for (char c : p.toCharArray()) {
        chars[c-'a']++;
    }
    int diff = len;
    char temp;
    for (end = 0; end<s.length(); end++) {
        if (end-start >= len) {
            temp = s.charAt(start);
            
            chars[temp-'a']++;
            
            if (chars[temp-'a'] > 0) {
                diff++;
            }
            start++;
        }
        
        temp = s.charAt(end);
        chars[temp-'a']--;
        
        if (chars[temp-'a'] >= 0) {
            diff--;
        }
        
        if (diff == 0) ans.add(start);
    }
    
    return ans;
}
}
