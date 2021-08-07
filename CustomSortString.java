import java.util.*;

public class CustomSortString {
  public String customSortString(String order, String s) {
    Map<Character, Integer> map=new LinkedHashMap<>();
    
    for (char c : order.toCharArray()) {
        map.put(c, 0);
    }
    StringBuilder sb = new StringBuilder();
    for (char ch : s.toCharArray()) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch)+1);
        }
        else {
            sb.append(ch);
        }
    }
    
    StringBuilder ans = new StringBuilder();
    
    for (char key : map.keySet()) {
        if (map.get(key) > 0) {
            int count = 0;
            while (count < map.get(key)) {
                ans.append(key);
                count++;
            }
        }
    }
    
    ans.append(sb);
    
    return ans.toString();
    
  }
}
