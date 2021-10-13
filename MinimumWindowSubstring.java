import java.util.*;
public class MinimumWindowSubstring {
  Map<Character, Integer> map = new HashMap();   
    
  public int difference() {
      for (char key : map.keySet()) {
          if (map.get(key) > 0) return 1;
      }
      return 0;
  }
  
  public String minWindow(String s, String t) {
      int end = 0;
      int start = 0;
      
      for (char c : t.toCharArray()) {
          map.put(c, map.getOrDefault(c,0)+1);
      }

      
      int min = Integer.MAX_VALUE;
      String minStr = "";
      for (end = 0; end<s.length(); end++) {
          //expand right
          if (map.containsKey(s.charAt(end))) map.put(s.charAt(end), map.get(s.charAt(end))-1);
          while (difference() == 0) {
              //shrink from left
              if (min > end-start) {
                  minStr = s.substring(start, end+1);
                  min = end-start;
              }
              if (map.containsKey(s.charAt(start))) map.put(s.charAt(start), map.get(s.charAt(start))+1);
              start++;
          }
  
      }
    
      return minStr;
  }
  
}
