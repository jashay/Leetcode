import java.util.*;
public class RepeatedDNASequence {
  public List<String> findRepeatedDnaSequences(String s) {
    Map<String, Integer> map= new HashMap<>();
    List<String> ans = new ArrayList<>();
    String sub = "";
    for (int end=0; end<s.length(); end++) {
        if (sub.length() >= 10) {  
            sub = sub.substring(1, sub.length());
        }
        
        sub += s.charAt(end);
        
        if (map.containsKey(sub)) {
            if (map.get(sub) == 1) {
                ans.add(sub);
            }
            map.put(sub, map.get(sub)+1);
        } 
        else {
            map.put(sub, 1);
        }
    }
    
    return ans;
  }
}
