import java.util.*;

public class JewelsStones {
  Set<Character> set = new HashSet<>();
        
  for (char x : jewels.toCharArray()) {
      set.add(x); 
  }
  
  
  int count = 0;
  
  for (char c : stones.toCharArray()) {
      if (set.contains(c)) {
          count++;
      }
  }
        
  return count;
}
